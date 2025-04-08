package org.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.sid", "com.project.cvtheque"})
@EnableJpaRepositories(basePackages = "com.project.cvtheque.repository")
@EntityScan(basePackages = "com.project.cvtheque.model")
public class CvthequeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CvthequeApplication.class, args);
    }
}