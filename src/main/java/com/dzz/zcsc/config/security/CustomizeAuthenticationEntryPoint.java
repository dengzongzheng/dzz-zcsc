package com.dzz.zcsc.config.security;

import com.alibaba.fastjson.JSON;
import com.dzz.zcsc.common.response.ResponseDzz;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * 处理AuthenticationEntryPoint
 * 匿名访问授保护资源时由此类处理
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 14:51
 */
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException e) throws IOException, ServletException {

        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(ResponseDzz.fail("权限不足")));
        out.flush();
        out.close();
    }
}
