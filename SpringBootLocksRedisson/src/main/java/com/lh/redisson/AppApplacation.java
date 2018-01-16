package com.lh.redisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author T-lih
 */
@SpringBootApplication
@ComponentScan(value = "com.lh.*")
public class AppApplacation {
    public static void main(String[] args) {
        SpringApplication.run(AppApplacation.class, args);
    }
}
