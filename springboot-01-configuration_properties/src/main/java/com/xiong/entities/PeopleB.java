package com.xiong.entities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "peopleb")
@PropertySource(value = {"classpath:people.properties"})
@Data
public class PeopleB {

    //todo: 添加@Value进行取值会造成创建Bean失败
    //@Value("${peopleb.name}")
    private String name;
}
