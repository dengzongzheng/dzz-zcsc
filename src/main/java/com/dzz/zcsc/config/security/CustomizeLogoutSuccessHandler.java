package com.dzz.zcsc.config.security;

import com.alibaba.fastjson.JSON;
import com.dzz.zcsc.common.response.ResponseDzz;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * 退出成功处理
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 16:21
 */
public class CustomizeLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
//        String message = "登录成功";
        out.write(JSON.toJSONString(ResponseDzz.ok()));
        out.flush();
        out.close();
    }
}
