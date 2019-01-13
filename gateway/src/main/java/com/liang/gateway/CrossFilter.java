package com.liang.gateway;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/**")
public class CrossFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我在CrossFilter中");

        //啥请求都允许跨域
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");

        //支持所有网站跨域，不能写成*，写成*就不能带cookie了
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        //用来设置自定义消息头的
        String header = request.getHeader("Access-Control-Request-Headers");

        if(!StringUtils.isBlank(header)){
            response.setHeader("Access-Control-Allow-Headers", header);

        }
        //response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type,token");

        response.setHeader("Access-Control-Allow-Credentials", "true"); //会带上cookie

        //这个字段中列举的 header 字段就是服务器允许暴露给客户端访问的字段，如果不设置，则前端response中会显示access-token，但是ajax拿不到token
        response.setHeader("Access-Control-Expose-Headers", "access-token");

        //如果是OPTIONS请求就return 往后执行会到业务代码中 他不带参数会产生异常
        if (request.getMethod().equals("OPTIONS")) {
            System.out.println("受到了一个options请求");
            return;
        }
        //第二次就是POST请求 之前设置了跨域就能正常执行代码了
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

