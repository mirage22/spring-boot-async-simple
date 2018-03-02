package com.mirage22.springboot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Miroslav Wengner (@miragemiko)
 */

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SimpleWebApplicationTests {
    public static void main(String[] args) {
        SpringApplication.run(SimpleWebApplicationTests.class, args);
    }
}
