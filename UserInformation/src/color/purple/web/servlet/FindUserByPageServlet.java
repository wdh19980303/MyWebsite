package color.purple.web.servlet;

import color.purple.domain.PageBean;
import color.purple.domain.User;
import color.purple.service.UserService;
import color.purple.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;

@WebServlet("/FindUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提前设置了编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 正式代码
        // 1 获取参数
        String currentPage = request.getParameter("currentPage"); //当前页码
        String rows = request.getParameter("rows");// 每页显示的条数
        if (currentPage == null || "".equals(currentPage) ) {
            currentPage = "1";
        }

        if (rows == null || "".equals(rows)) {
            rows = "10";
        }



        /***********************************************条件查询***************************************************/
        // 获取参数
        Map<String, String[]> condition = request.getParameterMap();
//        System.out.println(condition);
//        System.out.println(Arrays.toString(condition.get("name")));
//        System.out.println(Arrays.toString(condition.get("address")));

        /******************************************************************************************************/

        // 2 调用查询
        UserService userService = new UserServiceImpl();
        PageBean<User> pageBean = userService.findUserByPage(currentPage, rows, condition);
//        System.out.println(pageBean);
        // 3 将PageBean存入request
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("condition",condition);

        // 4 转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
//        System.out.println("-----------");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
