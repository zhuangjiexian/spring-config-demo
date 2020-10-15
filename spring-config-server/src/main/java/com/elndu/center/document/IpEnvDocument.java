package com.elndu.center.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author elndu
 * @version 1.0, 2020/10/14 20:49
 * @since JDK 1.8
 */
@Document(collection="ip_env")
@Data
public class IpEnvDocument
{
    @Id
    private String id;

    /**
     * IP
     */
    private String ip;

    /**
     * 环境
     */
    private String env;

}
