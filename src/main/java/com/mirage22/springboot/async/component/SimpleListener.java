package com.mirage22.springboot.async.component;

import com.mirage22.springboot.async.event.SimpleEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Miroslav Wengner (@miragemiko)
 */
@Component
public class SimpleListener implements ApplicationListener<SimpleEvent> {

    @Override
    public void onApplicationEvent(SimpleEvent event) {
        System.out.println(getClass().getSimpleName() + " received event: " + event);
    }
}
