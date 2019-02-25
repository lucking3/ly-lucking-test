package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = {"com.example.demo" })
@EnableTransactionManagement
@EnableEurekaClient
public class DemoApplication {


    private final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        if (logger.isDebugEnabled()) {
            logger.debug("启动基础数据服务......");
        }
        SpringApplication.run(DemoApplication.class, args);
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","^");
    }

}
