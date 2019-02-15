package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //注解@EnableEurekaClient 表明自己是一个eurekaclient.
@EnableDiscoveryClient //通过@EnableDiscoveryClient向服务中心注册
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced //通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

