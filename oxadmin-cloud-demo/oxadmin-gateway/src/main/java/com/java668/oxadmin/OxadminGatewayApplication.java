package com.java668.oxadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Jerry
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OxadminGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OxadminGatewayApplication.class, args);
    }

}
