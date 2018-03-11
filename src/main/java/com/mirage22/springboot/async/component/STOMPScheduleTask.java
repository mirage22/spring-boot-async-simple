package com.mirage22.springboot.async.component;

import com.mirage22.springboot.async.dto.LocationResponse;
import com.mirage22.springboot.async.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Miroslav Wengner (@miragemiko)
 */

@Component
public class STOMPScheduleTask {

    private final SimpleService simpleService;
    private final SimpMessagingTemplate template;

    @Autowired
    public STOMPScheduleTask(SimpleService simpleService, SimpMessagingTemplate template) {
        this.simpleService = simpleService;
        this.template = template;
    }

    // this will send a message to an endpoint on which a client can subscribe
    @Scheduled(fixedRate = 5000)
    public void triggerLocation() {
        final LocationResponse result = new LocationResponse();
        result.setLatitude(simpleService.getDouble());
        result.setLongitude(simpleService.getDouble());
        System.out.println(getClass().getSimpleName() + ":result:" + result);
        this.template.convertAndSend("/socket/topic/location", result);
    }



}
