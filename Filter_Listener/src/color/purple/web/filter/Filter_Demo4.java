package color.purple.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp") //资源拦截
//@WebFilter("/user/*") // 目录拦截
//@WebFilter("*.jsp" ) // 后缀名拦截
public class Filter_Demo4 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 正式代码

        System.out.println("demo 4 ----start");
        chain.doFilter(req, resp);// 放行

        System.out.println("demo 4 ----end");
    }


    public void destroy() {

    }


    public void init(FilterConfig config) throws ServletException {

    }

}
