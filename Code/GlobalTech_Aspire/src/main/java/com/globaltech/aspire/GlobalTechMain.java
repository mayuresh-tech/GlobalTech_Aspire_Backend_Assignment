package com.globaltech.aspire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.globaltech.aspire.repository")
@EntityScan("com.globaltech.aspire.entity")
@ComponentScan(basePackages = "com.globaltech.aspire")
public class GlobalTechMain extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/aspire");
        SpringApplication.run(GlobalTechMain.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GlobalTechMain.class);
    }
}
