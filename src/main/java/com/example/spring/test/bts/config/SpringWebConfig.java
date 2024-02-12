package com.example.spring.test.bts.config;

import com.example.spring.test.bts.helpers.Response;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SpringWebConfig implements WebMvcConfigurer {
    @Bean
    public ErrorAttributes errorAttributes() {

        return new DefaultErrorAttributes() {
            @Override
            public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
                Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
                Map<String, Object> errorMap = new HashMap<>();
                return Response.baseResponseMap(errorAttributes.get("error").toString());
            }
        };
    }
}
