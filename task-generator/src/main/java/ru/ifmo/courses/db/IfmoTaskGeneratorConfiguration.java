package ru.ifmo.courses.db;

import com.tuneit.courses.db.service.TaskGeneratorConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring configuration bean
 */
@Configuration
@ComponentScan("ru.ifmo.courses.db")
@Import(TaskGeneratorConfiguration.class)
public class IfmoTaskGeneratorConfiguration {
}
