package com.xiong.entities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;


// @ConfigurationProperties 依赖于 @Component 或者 @EnableConfigurationProperties, 前者写在当前类上, 后者写在配置类上, 二者选其一
// @ConfigurationProperties 和 @PropertySource 搭配使用
// @ConfigurationProperties: 指定前缀
// @PropertySource: 指定配置文件路径, 默认情况下使用application.properties或则application.yaml

@ConfigurationProperties(prefix = "people")
@PropertySource(value = {"classpath:people.properties"})
@Data
public class People {
    private String name;
}
