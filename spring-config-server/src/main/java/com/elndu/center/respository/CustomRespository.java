package com.elndu.center.respository;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author elndu
 * @version 1.0, 2020/10/14 20:57
 * @since JDK 1.8
 */
public interface CustomRespository
{
    /**
     * [简要描述]:通过ip获取环境
     * [详细描述]:<br/>
      * @param ip :
     * @return java.lang.String
     * elndu  2020/10/15 - 9:00
     **/
    String queryEnvByIP(String ip);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
      * @param env :
     * @param applicationCode :
     * @return java.lang.String
     * elndu  2020/10/15 - 9:07
     **/
    String queryApplicationConfig(String env,String applicationCode);
}
