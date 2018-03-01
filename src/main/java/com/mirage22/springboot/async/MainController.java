package com.mirage22.springboot.async;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

/**
 * @author Miroslav Wengner (@miragemiko)
 */
@Controller
public class MainController {

    @Value("${application.message:Example Hello World}")
    private String message = "Example: Hello World";

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }
}
