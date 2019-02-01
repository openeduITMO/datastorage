package com.tuneit.edx.lti;

import com.tuneit.courses.TaskGeneratorConfiguration;
import com.tuneit.edx.lti.config.RequestContextListenerConfiguration;
import com.tuneit.edx.lti.config.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@SpringBootApplication
@Import(TaskGeneratorConfiguration.class)
public class Main extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(
            Main.class,
            WebConfig.class,
            RequestContextListenerConfiguration.class
            // may be add other config classes here
        );
    }
}
