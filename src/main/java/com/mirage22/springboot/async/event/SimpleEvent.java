package com.mirage22.springboot.async.event;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

/**
 * @author Miroslav Wengner (@miragemiko)
 */
public class SimpleEvent extends ApplicationEvent {

    private String content;
    private int number;
    private LocalDateTime time;

    public SimpleEvent(Object source, String content, int number, LocalDateTime time) {
        super(source);
        this.content = content;
        this.number = number;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public int getNumber() {
        return number;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "SimpleEvent{" +
                "content='" + content + '\'' +
                ", number=" + number +
                ", time=" + time +
                '}';
    }
}
