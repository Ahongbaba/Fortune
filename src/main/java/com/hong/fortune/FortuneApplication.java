package com.hong.fortune;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Ahong
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class FortuneApplication {

    public static void main(String[] args) {
        SpringApplication.run(FortuneApplication.class, args);
    }
}
