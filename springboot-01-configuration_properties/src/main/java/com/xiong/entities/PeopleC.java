package com.xiong.entities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "peoplec")
@Data
public class PeopleC {
    private String name;
}
