package com.fanhanfei.springweb.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangjunshuai
 * @date 2020/2/17
 * @description
 **/
@Component
public class InternalApiInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        /*KeepUser user = HttpRequestContext.get();

        if (user == null) {
            user = new KeepUser();
            fillUserFromCookie(user, request);
            HttpRequestContext.set(user);
        }
        if (StringUtils.isNotBlank(user.getUserName())) {
            AccessContext context = new AccessContext();
            context.setUsername(user.getUserName());
            context.setUserID(user.getUserId());
            AccessContextHolder.set(context);
        }*/
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        /*HttpRequestContext.clear();
        AccessContextHolder.clear();*/
    }

    /*private void fillUserFromCookie(KeepUser user, HttpServletRequest request) {
        if (StringUtils.isBlank(user.getUserId())) {
            user.setUserId(getCookieValue(request, WebConstants.CmsCookieName.USER_ID));
        }
        if (StringUtils.isBlank(user.getUserName())) {
            user.setUserName(getCookieValue(request, WebConstants.CmsCookieName.LDAP_USERNAME));
        }
    }*/

    private String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = WebUtils.getCookie(request, name);
        return cookie != null ? cookie.getValue() : null;
    }
}
