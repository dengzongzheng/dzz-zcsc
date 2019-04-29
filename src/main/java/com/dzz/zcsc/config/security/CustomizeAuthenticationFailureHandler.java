package com.dzz.zcsc.config.security;

import com.alibaba.fastjson.JSON;
import com.dzz.zcsc.common.response.ResponseDzz;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * 认证失败处理
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 13:50
 */
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException e) throws IOException {

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String message = "登录失败";
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            message = "用户名或密码输入错误，登录失败";
        }

        if(e instanceof DisabledException) {
            message = "用户被禁用，登录失败";
        }
        out.write(JSON.toJSONString(ResponseDzz.fail(message)));
        out.flush();
        out.close();
    }
}
