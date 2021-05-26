package com.xidian.attackmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({DataBaseConfig.class})
public class AttackmodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttackmodelApplication.class, args);
    }

}
