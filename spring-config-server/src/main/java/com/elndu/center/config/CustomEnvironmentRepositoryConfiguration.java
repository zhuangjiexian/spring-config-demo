package com.elndu.center.config;


import com.elndu.center.custom.CustomEnvironmentRepository;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomEnvironmentRepositoryConfiguration
{

    @Bean
    public EnvironmentRepository environmentRepository()
    {
        return new CustomEnvironmentRepository();
    }

}
