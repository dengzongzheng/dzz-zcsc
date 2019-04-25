package com.dzz.zcsc.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 公共属性配置
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月26 下午11:05
 */
@Configuration
@Data
public class UtilConfig {

    @Value("${file.upload.path}")
    private String uploadFilePath;

    @Value("${file.server.path}")
    private String imageServerPath;
}
