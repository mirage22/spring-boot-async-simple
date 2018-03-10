package com.mirage22.springboot.async.controller;

import com.mirage22.springboot.async.component.SimpleEvenPublisher;
import com.mirage22.springboot.async.dto.SimpleResponse;
import com.mirage22.springboot.async.model.SimpleMessage;
import com.mirage22.springboot.async.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Miroslav Wengner (@miragemiko)
 */

@RestController
@RequestMapping("/")
public class JsonSimpleController {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final SimpleEvenPublisher simpleEvenPublisher;
    private final SimpleService simpleService;

    @Autowired
    public JsonSimpleController(SimpleEvenPublisher simpleEvenPublisher, SimpleService simpleService) {
        this.simpleEvenPublisher = simpleEvenPublisher;
        this.simpleService = simpleService;
    }

    @RequestMapping(value = "/simple", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    SimpleMessage simpleMessage(@RequestParam(value = "content", required = false, defaultValue = "Simple Message") String content) {
        simpleEvenPublisher.actionAndPublishEvent(content);
        return new SimpleMessage(String.format("response: %s", content), counter.getAndIncrement());
    }

    @RequestMapping(value = "/noparams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    SimpleMessage simpleMessageNoParams() {
        return new SimpleMessage("No Params", counter.getAndIncrement());
    }

    @RequestMapping(value = "/service", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    SimpleResponse simpleResponse(){
        return simpleService.getSimpleResponse();
    }
}
