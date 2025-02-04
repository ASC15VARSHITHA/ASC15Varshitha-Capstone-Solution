package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("org.example.feignclient")
public class LoginApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(LoginApp.class, args);
    }
}
