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

@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提前设置了编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 正式代码

        // 1. 获取id
        // 2. 调用查询
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(Integer.parseInt(request.getParameter("id")));
        // 3. 存入request
        request.setAttribute("user", user);
        // 4. 转发
        request.getRequestDispatcher( "/update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
