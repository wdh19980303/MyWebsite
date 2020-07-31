package color.purple.web.filter;

import org.junit.runner.Request;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 完成登录验证
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 0 强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 正式代码
        // 1 获取资源的请求路径
        String uri = request.getRequestURI();
        // 2 判断相关路径
        if (uri.contains("/login.jsp") || uri.contains("/LoginServlet") || uri.contains("/index.jsp") || uri.contains("/CheckCodeServlet") || uri.contains("/css/") || uri.contains("/font/") || uri.contains("/js/")) {
            // 包含了这些路径,表示用户想登录
            // 放行
            chain.doFilter(req,resp);
        } else {
            Object loginSuccessfulUser = request.getSession().getAttribute("loginSuccessfulUser");
            if (loginSuccessfulUser != null) {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute("LOGIN_ERROR","你尚未登录");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }


    }


    public void destroy() {

    }


    public void init(FilterConfig config) throws ServletException {

    }

}
