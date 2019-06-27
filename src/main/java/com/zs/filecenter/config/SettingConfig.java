package com.zs.filecenter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "upload", ignoreInvalidFields = false)
@PropertySource("classpath:setting.properties")
@Component
@Data
public class SettingConfig {
    public String logFilePath = "";
}
