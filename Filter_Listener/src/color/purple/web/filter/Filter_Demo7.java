package color.purple.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;

@WebFilter("/*")
public class Filter_Demo7 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 正式代码
        System.out.println("filter 7 执行");
        chain.doFilter(req, resp);// 放行
        System.out.println("filter 7 回来了");

    }


    public void destroy() {

    }


    public void init(FilterConfig config) throws ServletException {

    }

}
