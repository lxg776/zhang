package com.zheng.cms.admin.shiro;

import com.alibaba.fastjson.JSON;
import com.zheng.cms.admin.util.CommonUtil;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.util.RedisUtil;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.rpc.api.UcenterUserOauthService;
import com.zheng.upms.client.util.RequestParameterUtil;
import org.apache.commons.lang.StringUtils;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * 重写authc过滤器
 * Created by shuzheng on 2017/3/11.
 */
public class WxAuthenticationFilter extends AuthenticationFilter {

    private final static Logger _log = LoggerFactory.getLogger(WxAuthenticationFilter.class);

    // 局部会话key
    private final static String ZHENG_WX_CLIENT_SESSION_ID = "zheng-wx-client-session-id";
    // 单点同一个code所有局部会话key
    private final static String ZHENG_WX_CLIENT_SESSION_IDS = "zheng-wx-client-session-ids";

    @Autowired
    UpmsSessionDao upmsSessionDao;

    @Autowired
    UcenterUserOauthService ucenterUserOauthService;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {



        return validateClient(request, response);


    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {


        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(getErrorJSONObject());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

        return true;
    }





    private String getErrorJSONObject(){

        FriendResult result =new FriendResult(FriendResultConstant.FAILED,null);
        result.setMessage("授权失败");
        //Map<String,Object> map =new HashMap<>();
        String jsonString = JSON.toJSONString(result);
        return  jsonString;

    }


    /**
     * 认证中心登录成功带回code
     * @param request
     */
    private boolean validateClient(ServletRequest request, ServletResponse response) {
        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        String sessionId = session.getId().toString();
        int timeOut = (int) session.getTimeout() / 1000;

        String token = request.getParameter("token");

        // 判断局部会话是否登录
        String cacheToken = RedisUtil.get(ZHENG_WX_CLIENT_SESSION_ID + "_" + session.getId());

        if (StringUtils.isNotBlank(token)&&token.equals(cacheToken)) {
            // 更新code有效期
            RedisUtil.set(ZHENG_WX_CLIENT_SESSION_ID + "_" + sessionId, cacheToken, timeOut);
            Jedis jedis = RedisUtil.getJedis();
            jedis.expire(ZHENG_WX_CLIENT_SESSION_ID + "_" + cacheToken, timeOut);
            jedis.close();
//            // 移除url中的code参数
//            if (null != request.getParameter("token")) {
//                String backUrl = RequestParameterUtil.getParameterWithOutCode(WebUtils.toHttp(request));
//                HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
//                try {
//                    httpServletResponse.sendRedirect(backUrl.toString());
//                } catch (IOException e) {
//                    _log.error("局部会话已登录，移除code参数跳转出错：", e);
//                }
//            } else {
//                return true;
//            }
            return true;
        }


        String code = request.getParameter("code");




        // 已拿到code
        if (StringUtils.isNotBlank(code)) {

            String openId = getOpenIdFromWx("123", "123", code);
            UcenterUser ucenterUser = ucenterUserOauthService.getUcentUserByOpenid(openId);

            if (ucenterUser != null) {

                String createToken = CommonUtil.getRandomString(12);


                RedisUtil.set(ZHENG_WX_CLIENT_SESSION_ID + "_" + sessionId, createToken, timeOut);
                // 保存code对应的局部会话sessionId，方便退出操作
                RedisUtil.sadd(ZHENG_WX_CLIENT_SESSION_ID + "_" + code, sessionId, timeOut);
                UserPassTypeToken userPassTypeToken = new UserPassTypeToken(ucenterUser.getUserName(), "");
                userPassTypeToken.setDoType(UserPassTypeToken.NO_CHECK_PASSWORD);
                subject.login(userPassTypeToken);
                HttpServletResponse httpServletResponse = WebUtils.toHttp(response);


//                try {
//                    // 移除url中的token参数
//                    String backUrl = RequestParameterUtil.getParameterWithOutCode(WebUtils.toHttp(request));
//                    httpServletResponse.sendRedirect(backUrl.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                return true;

            }
        }
        return false;
    }


    /**
     * 通过appId和appsecret 获取OpenId
     * @param appId
     * @param appsecret
     * @param code
     * @return
     */
    public String getOpenIdFromWx(String appId,String appsecret,String code){

        return "abcdefg";
    }


    /**
     * 获取token
     * @param openId
     * @return
     */
    public String getTokenByOpenId(String openId){

        return "abcdef666";
    }

}
