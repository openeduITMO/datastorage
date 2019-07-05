package ru.ifmo.edx.lti;

import com.tuneit.edx.lti.LtiConfiguration;
import com.tuneit.edx.lti.config.RequestContextListenerConfiguration;
import com.tuneit.edx.lti.config.WebConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.ifmo.courses.db.IfmoTaskGeneratorConfiguration;

/**
 * Startup entry point of Spring application
 *
 * @author alex
 */
@Slf4j
@Configuration
@SpringBootApplication
@Import({IfmoTaskGeneratorConfiguration.class, LtiConfiguration.class})
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
        );
    }
}
