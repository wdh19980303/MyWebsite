package color.purple.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class Filter_Demo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter in");
        chain.doFilter(req, resp);
        System.out.println("filter out");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
