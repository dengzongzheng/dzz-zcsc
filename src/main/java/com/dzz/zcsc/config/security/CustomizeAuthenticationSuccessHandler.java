package com.dzz.zcsc.config.security;

import com.alibaba.fastjson.JSON;
import com.dzz.zcsc.common.response.ResponseDzz;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 认证成功处理
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 13:55
 */
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private TokenUtils tokenUtils;

    public CustomizeAuthenticationSuccessHandler() {
        try {
            this.tokenUtils = new TokenUtils();
        }catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
//        String message = "登录成功";
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(ResponseDzz.ok(tokenUtils.generateToken(authentication))));
        out.flush();
        out.close();
    }
}
