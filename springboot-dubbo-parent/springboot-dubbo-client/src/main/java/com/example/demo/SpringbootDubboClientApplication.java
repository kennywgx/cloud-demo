package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * 路径：com.example.demo.controller
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/6/15 16:15
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@SpringBootApplication
@ImportResource("classpath:consumer.xml")
public class SpringbootDubboClientApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(SpringbootDubboClientApplication.class, args);
    }
}