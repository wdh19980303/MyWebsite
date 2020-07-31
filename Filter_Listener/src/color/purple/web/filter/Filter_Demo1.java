package color.purple.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器快速入门
 */
//@WebFilter("/*") // 访问所有资源都会拦截
public class Filter_Demo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter_Demo1");
        // 拦截后放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行");
    }

    @Override
    public void destroy() {

    }
}
