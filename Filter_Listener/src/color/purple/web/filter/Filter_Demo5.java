package color.purple.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
// 浏览器直接访问资源会被执行
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)

// 转发的时候会被执行
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)

// 浏览器直接访问或者转发会被执行
//@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class Filter_Demo5 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 正式代码
        System.out.println("_____________________________________");
        System.out.println("filter Demo 5");

        chain.doFilter(req, resp);// 放行


    }


    public void destroy() {

    }


    public void init(FilterConfig config) throws ServletException {

    }

}
