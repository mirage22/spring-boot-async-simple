package com.mirage22.springboot.async.component;

import com.mirage22.springboot.async.event.SimpleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Miroslav Wengner (@miragemiko)
 */
@Component
public class SimpleEvenPublisher {

    private AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void actionAndPublishEvent(final String message) {
        SimpleEvent simpleEvent = new SimpleEvent(this, message, counter.getAndIncrement(), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        int delay = ThreadLocalRandom.current().nextInt(5000, 10000);
        System.out.println(getClass().getSimpleName() + "message: " + message + ", delay: " + delay + ", counter:" + counter.get());
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getClass().getSimpleName() + "publish: " + message);
        applicationEventPublisher.publishEvent(simpleEvent);
    }
}
