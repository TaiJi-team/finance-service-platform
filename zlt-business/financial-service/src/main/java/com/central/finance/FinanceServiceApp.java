package com.central.finance;

import com.central.common.ribbon.annotation.EnableBaseFeignInterceptor;
import com.central.common.ribbon.annotation.EnableFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yuan.zk
 */
@EnableFeignClients
@EnableBaseFeignInterceptor
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication
public class FinanceServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(FinanceServiceApp.class, args);
    }
}
