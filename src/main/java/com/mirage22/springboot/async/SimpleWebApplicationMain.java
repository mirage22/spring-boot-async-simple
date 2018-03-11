package com.mirage22.springboot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * @author Miroslav Wengner (@miragemiko)
 */

@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableWebSocketMessageBroker
public class SimpleWebApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(SimpleWebApplicationMain.class, args);
    }
}
