package com.example.zuul.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        logger.info("----->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");

        if (StringUtils.isNotBlank(token)) {
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(200);
            requestContext.set("isSuccess", true);
            return null;
        } else {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(400);
            requestContext.setResponseBody("token is empty");
            requestContext.set("isSuccess", false);
            return null;
        }

    }
}
