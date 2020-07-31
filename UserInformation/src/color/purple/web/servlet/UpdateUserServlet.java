package color.purple.web.servlet;

import color.purple.domain.User;
import color.purple.service.UserService;
import color.purple.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提前设置了编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 正式代码
        System.out.println("-------");
        // 1 获取数据
        Map userMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, userMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用service
        UserService userService = new UserServiceImpl();
        if (userService.updateUser(user)) {
            // 跳转到查询主页面
            response.sendRedirect(request.getContextPath() + "/FindUserByPageServlet");
        }

        else{
            request.getRequestDispatcher("/error.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
