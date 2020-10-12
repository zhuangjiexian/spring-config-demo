package com.elndu.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringConfigClientApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringConfigClientApplication.class, args);
    }

}
