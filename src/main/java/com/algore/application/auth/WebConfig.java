package com.algore.application.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/").setCachePeriod(60 * 60 * 24 * 365);

        registry.addResourceHandler("/upload/**")
                .addResourceLocations("classpath:/static/upload/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/templates/css/");
    }
}
