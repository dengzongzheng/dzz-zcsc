package com.dzz.zcsc.website;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月23 23:40
 */
@RestController
@RequestMapping("/api")
public class GoodsController {

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

}
