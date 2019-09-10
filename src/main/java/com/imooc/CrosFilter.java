package com.imooc;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;

        //允许指定域
        //res.addHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        //允许指定方法
        //res.addHeader("Access-Control-Allow-Methods", "GET");

        //允许所有域
        res.addHeader("Access-Control-Allow-Origin", "*");
        //允许所有方法
        res.addHeader("Access-Control-Allow-Methods", "*");
        res.addHeader("Access-Control-Allow-Headers", "content-type");
        //3600秒之内不用再发送预检命令
        res.addHeader("Access-Control-Max-Age", "3600");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
