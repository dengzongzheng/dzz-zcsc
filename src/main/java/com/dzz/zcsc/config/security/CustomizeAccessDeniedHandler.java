package com.dzz.zcsc.config.security;

import com.alibaba.fastjson.JSON;
import com.dzz.zcsc.common.response.ResponseDzz;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * 无权限处理
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 13:39
 */
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(ResponseDzz.fail("权限不足")));
        out.flush();
        out.close();
    }
}
