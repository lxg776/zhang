package com.zheng.cms.admin.shiro;

import com.alibaba.fastjson.JSON;
import com.zheng.cms.admin.util.TokenUtil;
import com.zheng.cms.common.constant.FriendResult;
import com.zheng.cms.common.constant.FriendResultConstant;
import com.zheng.common.util.RedisUtil;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.rpc.api.UcenterUserOauthService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * 重写authc过滤器
 * Created by shuzheng on 2017/3/11.
 */
public class WxAuthenticationFilter extends AuthenticationFilter {

    private final static Logger _log = LoggerFactory.getLogger(WxAuthenticationFilter.class);



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


        int timeOut = (int) session.getTimeout() / 1000;

        String token = request.getParameter("token");

        // 判断局部会话是否登录
        String userName = RedisUtil.get(TokenUtil.ZHENG_WX_CLIENT_SESSION_ID + "_" + token);

        if (StringUtils.isNotBlank(userName)) {




            // 更新code有效期
            RedisUtil.set(TokenUtil.ZHENG_WX_CLIENT_SESSION_ID + "_" + token, userName, timeOut);
            Jedis jedis = RedisUtil.getJedis();
            jedis.expire(TokenUtil.ZHENG_WX_CLIENT_SESSION_ID + "_" + token, timeOut);
            jedis.close();
            return true;
        }


        String code = request.getParameter("wxCode");

        // 已拿到code
        if (StringUtils.isNotBlank(code)) {

            String openId = TokenUtil.getOpenIdFromWx("123", "123", code);
            UcenterUser ucenterUser = ucenterUserOauthService.getUcentUserByOpenid(openId);
            if (ucenterUser != null) {
                String newsToken = TokenUtil.getToken(session,ucenterUser.getUserName());
                request.setAttribute("newsToken",newsToken);
                return true;
            }
        }


        return false;
    }



}
