package com.xiong.config;

import com.xiong.entities.Cat;
import com.xiong.entities.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@Configuration: 表示当前类为配置类

//@ImportResource: 引入以前项目或其他项目中的配置文件


/**
 * @author xiong
 * @date 2022/10/24
 */
@Configuration(proxyBeanMethods = true)
@ImportResource(locations = {"classpath:beans.xml"})
public class XConfig {

    // 配置一个默认的bean,
    // 一般情况下用于导入外部的java类, 例如mysql驱动中的类对象, 因为源代码本身可能并没有使用SpringBoot的注解.
    // 而作为一个依赖, 我们也不应该去修改它的源代码, 否则可能造成不够通用
    @Bean
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("root");
        user.setAge(18);
        return user;
    }

    //@Condition条件装配, 可以通过 `Ctrl + H` 查看子注释

    @Bean
    //@ConditionalOnBean(type = "Cat")
    @ConditionalOnBean(name = {"cat"})
    public User user02() {
        User user = new User();
        user.setId(2);
        user.setName("admin");
        user.setAge(19);
        return user;
    }

    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("kitty");
        cat.setName("common");
        return cat;
    }

}
