package com.imooc;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        String origin = req.getHeader("Origin");

        if (!StringUtils.isEmpty(origin)){
            //带cookie的时候，origin必须是全匹配，不能使用*
            res.addHeader("Access-Control-Allow-Origin", origin);
        }


        //允许指定域
        //res.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        //允许指定方法
        //res.addHeader("Access-Control-Allow-Methods", "GET");

        //允许所有域
        //res.addHeader("Access-Control-Allow-Origin", "*");

        //允许所有方法
        res.addHeader("Access-Control-Allow-Methods", "*");


        String headers = req.getHeader("Access-Control-Request-Headers");

        //支持所有自定义头
        if (!StringUtils.isEmpty(headers)){
            res.addHeader("Access-Control-Allow-Headers", headers);
        }

        //3600秒之内不用再发送预检命令
        res.addHeader("Access-Control-Max-Age", "3600");

        //enable cookie
        res.addHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
