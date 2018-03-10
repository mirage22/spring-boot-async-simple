package com.mirage22.springboot.async.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Miroslav Wengner (@miragemiko)
 */
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent cse) {
        System.out.println("Handling context refresh event. ");
    }

}
