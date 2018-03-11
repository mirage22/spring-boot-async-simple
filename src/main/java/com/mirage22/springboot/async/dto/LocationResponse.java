package com.mirage22.springboot.async.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Miroslav Wengner (@miragemiko)
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {
    Double longitude;
    Double latitude;
}
