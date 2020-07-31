package color.purple.web.servlet;

import color.purple.domain.User;
import color.purple.service.UserService;
import color.purple.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提前设置了编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 正式代码
        // 1 获取验证码并校验
        String verifycode = request.getParameter("verifycode");
        if (!verifycode.equalsIgnoreCase((String) request.getSession().getAttribute("CHECKCODE_SERVER"))) {
            request.getSession().removeAttribute("CHECKCODE_SERVER");
            // 验证码不正确
            // 提示信息
            request.setAttribute("LOGIN_ERROR", "验证码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        // 获取登录
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);

        // 2 封装user
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        UserService userService = new UserServiceImpl();

        // 3 service查询
        User loginSuccessfulUser = userService.login(loginUser);

        // 4 判断密码是否正确
        if (loginSuccessfulUser == null) {
            request.setAttribute("LOGIN_ERROR","密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

       /* System.out.println(loginSuccessfulUser);*/
        /*request.setAttribute("loginSuccessfulUser", loginSuccessfulUser);*/
        request.getSession().setAttribute("loginSuccessfulUser", loginSuccessfulUser);
        request.getSession().setMaxInactiveInterval(60 * 60 * 3);
        request.getRequestDispatcher("/index.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
