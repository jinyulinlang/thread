package com.gao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration//使用java类的方式对spring相关信息进行配置
@ComponentScan("com.gao")//扫描com.gao包下面的类
@EnableAsync//支持异步
public class Config {



}
