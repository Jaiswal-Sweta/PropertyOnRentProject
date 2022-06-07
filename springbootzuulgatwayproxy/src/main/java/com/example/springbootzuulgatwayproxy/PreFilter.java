package com.example.springbootzuulgatwayproxy;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.ZuulFilter;

public class PreFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
        return null;
    }
}
