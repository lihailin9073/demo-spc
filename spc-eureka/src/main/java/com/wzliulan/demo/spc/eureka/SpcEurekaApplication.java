package com.wzliulan.demo.spc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpcEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcEurekaApplication.class, args);
    }

}
