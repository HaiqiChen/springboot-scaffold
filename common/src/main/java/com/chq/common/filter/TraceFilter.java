package com.chq.common.filter;

import org.slf4j.MDC;
import org.springframework.core.Ordered;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@WebFilter(filterName = "TraceFilter")
public class TraceFilter implements Filter, Ordered {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // TODO: 2021/9/3
        String requestId = request.getHeader("REQUEST_ID");
        MDC.put("REQUEST_ID", UUID.randomUUID().toString());
        try {
            ((HttpServletResponse) servletResponse).setHeader("REQUEST_ID", requestId);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove("REQUEST_ID");
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
