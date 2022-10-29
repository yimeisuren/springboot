package com.xiong;

import com.xiong.config.XConfig;
import com.xiong.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

//@SpringBootApplication = @EnableAutoConfiguration + @ComponentScan + @SpringBootConfiguration(@Configuration)
//@SpringBootApplication: 会自动扫描(隐藏于代码底层)当前类所在目录下的包, 相当于定义了一个基准路径

//exclude: 排除掉一些不希望自动配置的类

/**
 * @author xiong
 * @date 2022/10/24
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({XConfig.class})

//即使Java类并不是组件, 可以通过指定的方式来开启属性配置
@EnableConfigurationProperties(value = {People.class, PeopleB.class, PeopleC.class})
public class MyApplicationMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApplicationMain.class, args);

        //默认是单例模式
        User user = context.getBean("user", User.class);
        System.out.println(user);

        XConfig xConfig = context.getBean(XConfig.class);
        User user2 = xConfig.user();

        System.out.println(user == user2);

        // 获取某一个类型的所有bean
        String[] names = context.getBeanNamesForType(User.class);
        for (String name : names) {
            System.out.println(name);
        }

        // 判断容器中是否有某个组件
        boolean hasUser = context.containsBean("user02");
        System.out.println(hasUser);

        // 属性配置方式一: 引入组件 + 开启属性配置
        Person person = context.getBean("person", Person.class);
        System.out.println(person);

        Customer customer = context.getBean("customer", Customer.class);
        System.out.println(customer);

        // 属性配置方式二: 指定Java类 + 开启属性配置.
        // 这种方式配置下的JavaBean的id并不是类名首字母小写, 这种方式不能使用@PropertySource自定义配置文件路径, 只有默认配置文件才会生效. 这是为什么???
        People people = context.getBean(People.class);
        String[] peoplesName = context.getBeanNamesForType(People.class);
        for (String peopleName : peoplesName) {
            System.out.println(peopleName);
        }
        System.out.println(people);

        PeopleB peopleB = context.getBean(PeopleB.class);
        System.out.println(peopleB);

        PeopleC peopleC = context.getBean(PeopleC.class);
        System.out.println(peopleC);

    }
}
