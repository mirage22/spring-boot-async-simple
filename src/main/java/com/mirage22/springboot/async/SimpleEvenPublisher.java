package com.mirage22.springboot.async;

import com.mirage22.springboot.async.event.SimpleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Miroslav Wengner (@miragemiko)
 */
@Component
public class SimpleEvenPublisher {

    private int counter;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void actionAndPublishEvent(final String message) {
        SimpleEvent simpleEvent = new SimpleEvent(this, message, counter++, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        int delay = ThreadLocalRandom.current().nextInt(5000, 10000);
        System.out.println(getClass().getSimpleName() + "message: " + message + ", delay: " + delay + ", counter:" + counter);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getClass().getSimpleName() + "publish: " + message);
        applicationEventPublisher.publishEvent(simpleEvent);
    }
}
