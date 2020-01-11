package com.escalade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.escalade"})
@EnableTransactionManagement
@EntityScan(basePackages = {"com.escalade.entity"})
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
