package com.dzz.zcsc.website;

import com.dzz.zcsc.common.response.ResponseDzz;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月29 11:35
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController {

    @PostMapping("/login")
    public ResponseDzz login(HttpServletRequest request, @RequestParam("userName") String userName,
            @RequestParam("password") String password) {

        log.info("userName:{},password{}", userName, password);
        return ResponseDzz.ok("dddddd");
    }
}
