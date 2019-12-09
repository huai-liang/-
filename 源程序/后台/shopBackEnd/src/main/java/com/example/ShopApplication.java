package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ASUS
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.example.shop.*.mapper")
public class ShopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShopApplication.class, args);
        System.out.println("spring boot启动成功,端口为" + context.getEnvironment().getProperty("server.port"));

    }



}
