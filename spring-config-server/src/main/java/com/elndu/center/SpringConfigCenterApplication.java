package com.elndu.center;

import com.elndu.center.annotation.CustomEnableConfigServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@CustomEnableConfigServer
public class SpringConfigCenterApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringConfigCenterApplication.class, args);
    }

}
