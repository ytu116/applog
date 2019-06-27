package com.zs.filecenter.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootConfiguration
public class ApiVersionConfig extends WebMvcConfigurationSupport {
    
    /**
     * 重写请求过处理的方法
     */
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        //return super.requestMappingHandlerMapping();
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        return handlerMapping;
    }
}