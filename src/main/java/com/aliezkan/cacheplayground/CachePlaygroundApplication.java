package com.aliezkan.cacheplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachePlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachePlaygroundApplication.class, args);
    }

}
