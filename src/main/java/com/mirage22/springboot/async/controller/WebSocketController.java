package com.mirage22.springboot.async.controller;

import com.mirage22.springboot.async.dto.HelloMessage;
import com.mirage22.springboot.async.dto.SimpleResponse;
import com.mirage22.springboot.async.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miroslav Wengner (@miragemiko)
 */
@RequestMapping("/socket")
@Controller
public class WebSocketController {

    private final SimpleService simpleService;

    @Autowired
    public WebSocketController(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @MessageMapping("/number")
    @SendTo("/socket/topic/number")
    public SimpleResponse getNumber(HelloMessage message) {
        System.out.println(getClass().getSimpleName() + ":message:" + message);
        return simpleService.getSimpleResponse();
    }

    @GetMapping("/")
    public String socket(Map<String, Object> model) {
        model.put("time", new Date());
        return "index";
    }
}



