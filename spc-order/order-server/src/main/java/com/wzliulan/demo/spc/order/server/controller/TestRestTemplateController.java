package com.wzliulan.demo.spc.order.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequestMapping("/test-rest-template")
@RestController
public class TestRestTemplateController {

    // RestTemplate使用方式-1
    @GetMapping("/rtp-1")
    public Object restTemplate1() {
        RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.getForObject("http://localhost:10030/spc-goods/product/test-for-rtp", String.class);
        return res;
    }

    // RestTemplate使用方式-2
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping("/rtp-2")
    public Object restTemplate2() {
        // 构造负载均衡式的url
        ServiceInstance serviceInstance = loadBalancerClient.choose("spc-goods");
        String serviceUrl = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort());

        RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.getForObject(serviceUrl+"/spc-goods/product/test-for-rtp", String.class);
        return res;
    }

    // RestTemplate使用方式-3
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/rtp-3")
    public Object restTemplate3() {
        String serviceName = "SPC-GOODS"; // 服务名称
        String res = this.restTemplate.getForObject("http://"+serviceName+"/spc-goods/product/test-for-rtp", String.class);
        return res;
    }

}
