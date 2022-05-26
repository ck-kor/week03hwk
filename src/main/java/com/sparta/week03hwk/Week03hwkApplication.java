package com.sparta.week03hwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week03hwkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week03hwkApplication.class, args);
    }

}
