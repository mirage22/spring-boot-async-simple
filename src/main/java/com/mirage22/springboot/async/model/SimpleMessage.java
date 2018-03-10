package com.mirage22.springboot.async.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Miroslav Wengner (@miragemiko)
 */
@Data
@AllArgsConstructor
public class SimpleMessage {
    private String content;
    private Integer number;
}
