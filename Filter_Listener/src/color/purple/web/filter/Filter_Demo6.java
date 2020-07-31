package color.purple.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Filter_Demo6 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 正式代码
        System.out.println("filter 6 执行");
        chain.doFilter(req, resp);// 放行
        System.out.println("filter 6 回来");

    }


    public void destroy() {

    }


    public void init(FilterConfig config) throws ServletException {

    }

}
