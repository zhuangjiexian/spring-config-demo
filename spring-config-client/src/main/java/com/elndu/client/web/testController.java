package com.elndu.client.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author elndu
 * @version 1.0, 2020/10/12 11:07
 * @since JDK 1.8
 */
@RestController
@RefreshScope
public class testController
{
    @Value("${spring.profiles.active}")
    private String env;

    @GetMapping("/get/env")
    public String getUname()
    {
        return this.env;
    }
}
