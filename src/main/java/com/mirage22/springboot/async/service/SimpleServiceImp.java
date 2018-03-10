package com.mirage22.springboot.async.service;

import com.mirage22.springboot.async.dto.SimpleResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Miroslav Wengner (@miragemiko)
 */

@Service
public class SimpleServiceImp implements SimpleService {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();


    @Override
    public SimpleResponse getSimpleResponse() {
        final SimpleResponse result = new SimpleResponse();
        result.setNumber(random.nextInt(0, 1000));
        return result;
    }
}
