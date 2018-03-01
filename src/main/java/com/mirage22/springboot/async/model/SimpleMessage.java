package com.mirage22.springboot.async.model;

/**
 * @author Miroslav Wengner (@miragemiko)
 */
public class SimpleMessage {
    private String content;
    private Integer number;


    public SimpleMessage(String content, Integer number) {
        this.content = content;
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public Integer getNumber() {
        return number;
    }
}
