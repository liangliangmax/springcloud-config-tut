package com.liang.consumer;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Configuration
public class HeaderConfig implements RequestInterceptor{

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);

                //一下所有的字段是从request的header中取出的，别的都没影响，唯独加上Content-Length之后报错，
                //这个value取出来是0，可能是这个0导致了发送的请求没有被正确处理，总是提示接受数据之前连接关闭
                if(name.equals("Content-Length")
                        //name.equals("Origin")
                        //|| name.equals("Accept")
                        //|| name.equals("X-Requested-With")
                        //|| name.equals("x-forwarded-proto")
                        //|| name.equals("Connection")
                        //|| name.equals("Referer")
                        //|| name.equals("User-Agent")
                        //|| name.equals("x-forwarded-port")
                        //|| name.equals("Accept-Encoding")
                        //|| name.equals("Pragma")
                        //|| name.equals("x-forwarded-for")
                        //|| name.equals("authorization")
                        //|| name.equals("Cache-Control")
                        //|| name.equals("x-forwarded-host")
                        //|| name.equals("x-forwarded-prefix")
                        //|| name.equals("host")
                        //|| name.equals("Accept-Language")
                        ){
                    continue;
                }
                requestTemplate.header(name, values);

            }
        }
    }

}
