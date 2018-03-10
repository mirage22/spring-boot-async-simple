package com.mirage22.springboot.async.component;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Miroslav Wengner (@miragemiko)
 */


@Component
public class ScheduledTask {


//    @Scheduled(initialDelay = 1000, fixedRate = 1000)
    public void sendScheduledMessage(){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "http://localhost:8080/simple";
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl , String.class);

        System.out.println(getClass().getSimpleName() + ":response:" + response);
    }
}
