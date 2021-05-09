package com.wxm.springcloud.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by 高等数学 on 2021/5/9.
 */
@WebFilter(urlPatterns = "/*",filterName ="f1")
public class LoginFilter implements Filter {


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest servlet = (HttpServletRequest ) servletRequest;

        String uri = servlet.getRequestURI();
        if (uri.indexOf("login")>-1 || uri.indexOf("html")>-1 ||uri.indexOf("js")>-1  || uri.indexOf("css")>-1){
            filterChain.doFilter(servletRequest,servletResponse);

        }else if(uri.indexOf("tour")>-1){
            //这里要判断token是否存在
            String token = servlet.getHeader("token");
            System.out.println(token);

            filterChain.doFilter(servletRequest,servletResponse);

        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }




    }
}
