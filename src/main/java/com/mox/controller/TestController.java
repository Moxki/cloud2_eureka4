package com.mox.controller;

import com.mox.entity.AoaCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("list")
    public AoaCatalog[] list(Model m) {
//      String url = "http://localhost:8080/list";
        List<ServiceInstance> instanceList = discoveryClient.getInstances("cloud2-s");
        ServiceInstance serviceInstance = instanceList.get(0);
        String baseUrl = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/list";
        return restTemplate.getForObject(baseUrl, AoaCatalog[].class);
    }
}
