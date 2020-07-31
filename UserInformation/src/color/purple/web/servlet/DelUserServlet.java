package color.purple.web.servlet;

import color.purple.service.UserService;
import color.purple.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.IdentityHashMap;

@WebServlet("/DelUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提前设置了编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 正式代码
        // 1. 获取id
//        System.out.println("______________" + request.getParameter("id"));
        int id = Integer.parseInt(request.getParameter("id"));
//        System.out.println(id);
        // 2. 调用删除
        UserService userService = new UserServiceImpl();

        if (userService.delUser((int) id)) {
            response.sendRedirect(request.getContextPath()+"/FindUserByPageServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
