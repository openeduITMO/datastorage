package com.tuneit.edx.lti.config;

import com.tuneit.edx.lti.web.EdxUserExtractorFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    public static final String ATTRIBUTE_USER_INFO = "edx-user-info";

    @Bean
    public FilterRegistrationBean loggingFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new EdxUserExtractorFilter());
        registrationBean.addUrlPatterns("/api/rest/lti/*", "/debug/*");

        return registrationBean;
    }

}
