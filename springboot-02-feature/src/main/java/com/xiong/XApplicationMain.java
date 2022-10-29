package com.xiong;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//1. 可以通过放置一张banner.xxx的图片或文本文件来替换SpringBoot的默认标志

/**
 * @author xiong
 * @date 2022/10/24
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class XApplicationMain {
    public static void main(String[] args) {
        //自定义SpringApplication
        SpringApplication application = new SpringApplication(XApplicationMain.class);
        //取消了Banner
        application.setBannerMode(Banner.Mode.OFF);
        //设置懒加载为false, 默认为false, 仅仅为了测试
        application.setLazyInitialization(false);
        application.run(args);
    }
}
