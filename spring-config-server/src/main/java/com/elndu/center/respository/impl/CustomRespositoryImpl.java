package com.elndu.center.respository.impl;

import com.elndu.center.document.ApplicationConfigDocument;
import com.elndu.center.document.IpEnvDocument;
import com.elndu.center.respository.CustomRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author elndu
 * @version 1.0, 2020/10/14 20:58
 * @since JDK 1.8
 */
@Component
public class CustomRespositoryImpl implements CustomRespository
{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String queryEnvByIP(String ip)
    {
        List<IpEnvDocument> ipEnvDocuments = mongoTemplate
                .find(new Query(Criteria.where("ip").is(ip)), IpEnvDocument.class);
        if (CollectionUtils.isEmpty(ipEnvDocuments))
        {
            return null;
        }
        return ipEnvDocuments.get(0).getEnv();
    }

    @Override
    public String queryApplicationConfig(String env, String applicationCode)
    {
        List<ApplicationConfigDocument> applicationConfigDocuments = mongoTemplate
                .find(new Query(Criteria.where("env").is(env).and("applicationCode")
                        .is(applicationCode)), ApplicationConfigDocument.class);
        if (CollectionUtils.isEmpty(applicationConfigDocuments))
        {
            return null;
        }
        return applicationConfigDocuments.get(0).getConfig();
    }
}
