package com.myspringbootlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
        System.out.println("++++++++++++++++++++++++"+SpringApplication.class.getClassLoader().getResource("META-INF/spring.factories"));
    }

}
