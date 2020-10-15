package com.elndu.center;

import com.elndu.center.document.ApplicationConfigDocument;
import com.elndu.center.document.IpEnvDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author elndu
 * @version 1.0, 2020/10/15 12:38
 * @since JDK 1.8
 */
public class DataCreateTest extends SpringConfigCenterApplicationTests
{
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void testAddIpAndEnv(){
        IpEnvDocument devEnv = new IpEnvDocument();
        IpEnvDocument testEnv = new IpEnvDocument();

        devEnv.setEnv("dev");
        devEnv.setIp("172.16.68.148");
        testEnv.setEnv("test");
        testEnv.setIp("172.16.68.140");
        mongoTemplate.save(devEnv);
        mongoTemplate.save(testEnv);
    }


    @Test
    public void testAddApplicationConfig(){
        ApplicationConfigDocument devConfig = new ApplicationConfigDocument();
        ApplicationConfigDocument testConfig = new ApplicationConfigDocument();

        devConfig.setEnv("dev");
        devConfig.setApplicationCode("spring-config-client");
        devConfig.setConfig("spring:\n" + "  profiles:\n" + "    active: dev");

        testConfig.setEnv("test");
        testConfig.setApplicationCode("spring-config-client");
        testConfig.setConfig("spring:\n" + "  profiles:\n" + "    active: test");
        mongoTemplate.save(devConfig);
        mongoTemplate.save(testConfig);
    }
}
