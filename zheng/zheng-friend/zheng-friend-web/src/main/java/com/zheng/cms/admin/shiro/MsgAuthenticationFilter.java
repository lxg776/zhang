package com.zheng.cms.admin.shiro;


import com.zheng.common.util.PropertiesFileUtil;

import com.zheng.friend.dao.model.FUserSetting;
import com.zheng.friend.rpc.api.FUserSettingService;
import com.zheng.ucenter.dao.model.UcenterUser;
import com.zheng.ucenter.rpc.api.UcenterUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



/**
 * 重写authc过滤器
 * Created by shuzheng on 2017/3/11.
 */
public class MsgAuthenticationFilter extends AuthenticationFilter {

    private final static Logger _log = LoggerFactory.getLogger(MsgAuthenticationFilter.class);



    @Autowired
    UpmsSessionDao upmsSessionDao;
    @Autowired
    UcenterUserService ucenterUserService;
    @Autowired
    FUserSettingService fUserSettingService;



    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
         Subject subject = getSubject(request, response);
         Session session = subject.getSession();
         String  userName = (String) SecurityUtils.getSubject().getPrincipal();
         UcenterUser ucenterUser = (UcenterUser) session.getAttribute(userName);
         if(ucenterUser==null){
            ucenterUser	= ucenterUserService.selectUpmsUserByUsername(userName);
            ucenterUser.setPassword("");
             session.setAttribute(userName,ucenterUser);
         }
        FUserSetting fUserSetting =  fUserSettingService.selectByPrimaryKey(ucenterUser.getUserId());

         Byte state = 1;

        if(fUserSetting!=null&&fUserSetting.getMsgReadStatus().equals(state)&&fUserSetting.getMsgSendStatus().equals(state)) {
            return  true;
        }
            return false;
    }





    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        StringBuffer sso_server_url = new StringBuffer(PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.sso.server.url"));


//        // 回跳地址
//        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
//        StringBuffer backurl = httpServletRequest.getRequestURL();
//        String queryString = httpServletRequest.getQueryString();
//        if (StringUtils.isNotBlank(queryString)) {
//            backurl.append("?").append(queryString);
//        }

        sso_server_url.append("/u/").append("openMenber");
        WebUtils.toHttp(response).sendRedirect(sso_server_url.toString());
        return false;
    }



}
