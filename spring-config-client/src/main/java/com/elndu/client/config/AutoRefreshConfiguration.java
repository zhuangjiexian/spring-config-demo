package com.elndu.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author elndu
 * @version 1.0, 2020/10/3 16:32
 * @since JDK 1.8
 */

@Configuration
public class AutoRefreshConfiguration
{

    @Autowired
    private ContextRefresher contextRefresher;

    /**
     * 定时去执行refresh方法,去拉取配置
     */
    @Scheduled(fixedRate = 2000L)
    public void autoRefreshConfig() {
        contextRefresher.refresh();
    }

}
