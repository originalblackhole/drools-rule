package com.example.droolsrule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.droolsrule")
@SpringBootApplication
public class DroolsRuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DroolsRuleApplication.class, args);
    }

}
