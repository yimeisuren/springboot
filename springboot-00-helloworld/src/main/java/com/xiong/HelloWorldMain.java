package com.xiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@RestController = @Controller + @ResponseBody
//@Controller: 表示作为控制器接收web请求
//@ResponseBody: 表示返回结果不经过视图解析器, 直接返回给请求调用方caller

//@RequestMapping: 表示发送方满足该规则时, 调用该方法


/**
 * @author xiong
 * @date 2022/10/23
 */
@RestController
@EnableAutoConfiguration
public class HelloWorldMain {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    /**
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldMain.class, args);
    }
}







