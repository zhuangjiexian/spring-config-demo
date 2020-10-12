package com.elndu.center.custom;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author elndu
 * @version 1.0, 2020/10/12 19:28
 * @since JDK 1.8
 */
public class CustomEnvironmentRepository implements EnvironmentRepository, Ordered
{

    private static final String CLIENT_HOST = "ClientServerHost";
    private static final String CLIENT_PORT = "ClientServerPort";

    /**
     * Squid 服务代理
     */
    private static final String X_FORWARDED_FOR = "X-Forwarded-For";
    /**
     * apache 服务代理
     */
    private static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    /**
     * weblogic 服务代理
     */
    private static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    /**
     * http 其他代理
     */
    private static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    /**
     * nginx服务代理
     */
    private static final String X_REA_IP = "X-Real-IP";
    private static final String UNKNOWN = "unknown";

    private int order = Ordered.LOWEST_PRECEDENCE - 10;

    @Override
    public Environment findOne(String application, String profile, String label)
    {
        return null;
    }

    @Override
    public int getOrder()
    {
        return 0;
    }

    private String originalClientIp()
    {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        String ip = "";
        if (null != servletRequestAttributes)
        {
            HttpServletRequest request = servletRequestAttributes.getRequest();

            //获取IP
            ip = request.getHeader(CLIENT_HOST);
            if (StringUtils.isBlank(ip))
            {
                ip = getClientIp(request);
            }
        }
        return ip;
    }

    /**
     * [简要描述]:获取原始IP
     * [详细描述]:<br/>
     *
     * @param request :
     * @return java.lang.String
     * jiexianzhuang  2020/10/10 - 14:29
     **/
    private String getClientIp(HttpServletRequest request)
    {
        String ip = null;
        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader(X_FORWARDED_FOR);
        if (isEmpty(ipAddresses) || UNKNOWN.equalsIgnoreCase(ipAddresses))
        {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader(PROXY_CLIENT_IP);
        }
        if (isEmpty(ipAddresses) || UNKNOWN.equalsIgnoreCase(ipAddresses))
        {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader(WL_PROXY_CLIENT_IP);
        }
        if (isEmpty(ipAddresses) || UNKNOWN.equalsIgnoreCase(ipAddresses))
        {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader(HTTP_CLIENT_IP);
        }
        if (isEmpty(ipAddresses) || UNKNOWN.equalsIgnoreCase(ipAddresses))
        {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader(X_REA_IP);
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0)
        {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (isEmpty(ip) || UNKNOWN.equalsIgnoreCase(ipAddresses))
        {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
