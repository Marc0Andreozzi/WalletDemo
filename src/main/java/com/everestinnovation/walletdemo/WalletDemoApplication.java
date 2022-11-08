package com.everestinnovation.walletdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class })
public class WalletDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletDemoApplication.class, args);
    }

}
