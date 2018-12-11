package com.moon.immncweb.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author zhaoxiang
 * @Date 2018/11/28
 * @Desc
 */
@Data
@Component
@ConfigurationProperties(prefix = "weburl")
public class WebUrlConfig {
    private String imgPrefix;
}
