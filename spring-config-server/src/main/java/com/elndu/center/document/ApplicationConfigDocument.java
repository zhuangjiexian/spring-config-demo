package com.elndu.center.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author elndu
 * @version 1.0, 2020/10/14 20:51
 * @since JDK 1.8
 */
@Document(collection="application_config")
@Data
public class ApplicationConfigDocument
{
    @Id
    private String id;

    /**
     * 环境
     */
    private String env;

    /**
     * 应用配置编码
     */
    private String applicationCode;

    /**
     * 配置
     */
    private String config;
}
