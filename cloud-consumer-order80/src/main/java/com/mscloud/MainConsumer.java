package com.mscloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MainConsumer {
    public static void main(String[] args) {
        SpringApplication.run(MainConsumer.class,args);
    }
}
