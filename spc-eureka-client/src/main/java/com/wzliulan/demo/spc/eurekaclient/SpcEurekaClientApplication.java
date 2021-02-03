package com.wzliulan.demo.spc.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpcEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcEurekaClientApplication.class, args);
    }

}
