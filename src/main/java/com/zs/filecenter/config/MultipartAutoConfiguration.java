package com.zs.filecenter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;

@Configuration
@ConditionalOnClass({WebMvcProperties.Servlet.class, StandardServletMultipartResolver.class, MultipartConfigElement.class})
@ConditionalOnProperty(prefix = "spring.http.multipart", name = "enabled", matchIfMissing = true)
@EnableConfigurationProperties(MultipartProperties.class)
public class MultipartAutoConfiguration {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        //   // this.multipartProperties.setMaxFileSize("-1"); // 不限图片大小
        //   // return this.multipartProperties.createMultipartConfig();

        //// 【方式1】
        //   // 设置图片上传大小上限是20m
        //   MultipartConfigFactory factory = new MultipartConfigFactory();
        //   //文件最大
        //   factory.setMaxFileSize("20480KB"); // KB,MB
        //   /// 设置总上传数据总大小
        //   factory.setMaxRequestSize("25480KB");
        //   return factory.createMultipartConfig();
        //// ...............................................................

        //// 【方式2】
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大20M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(20, DataUnit.MEGABYTES));
        /// 设置总上传数据总大小40M
        factory.setMaxRequestSize(DataSize.of(40, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
    @ConditionalOnMissingBean(MultipartResolver.class)
    public StandardServletMultipartResolver multipartResolver() {
        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
        multipartResolver.setResolveLazily(false);
        return multipartResolver;
    }
}