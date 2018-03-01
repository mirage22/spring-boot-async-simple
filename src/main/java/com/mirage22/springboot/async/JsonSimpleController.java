package com.mirage22.springboot.async;

import com.mirage22.springboot.async.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/simple")
public class JsonSimpleController {

    private final AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    private SimpleEvenPublisher simpleEvenPublisher;

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody SimpleMessage simpleMessage(@RequestParam(value="content", required=false, defaultValue="Simple Message") String content) {
        simpleEvenPublisher.actionAndPublishEvent(content);
        return new SimpleMessage(String.format("response: %s", content), counter.getAndIncrement());
    }

}
