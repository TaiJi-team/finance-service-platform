package com.central.login;

import com.central.common.ribbon.annotation.EnableFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yzb
 */
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableFeignInterceptor
@SpringBootApplication
public class AuthenticationServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServiceApp.class, args);
    }
}
