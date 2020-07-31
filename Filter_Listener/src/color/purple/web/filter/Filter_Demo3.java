package color.purple.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")WebFilter
public class Filter_Demo3 implements Filter {
    public void destroy() {
        System.out.println("destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 正式代码
        System.out.println("doFilter");

        chain.doFilter(req, resp);// 放行
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init");
    }

}
