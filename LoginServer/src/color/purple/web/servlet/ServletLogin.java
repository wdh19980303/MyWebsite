package color.purple.web.servlet;

import color.purple.web.Dao.UserDao;
import color.purple.web.User.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提前设置了编码
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");

        // 判断验证码
        // 1.输入的验证码
        String checkCode = request.getParameter("checkCode");
        // 2.获取生成的验证码
        String checkCode_Session = (String) request.getSession().getAttribute("checkCode_Session");
        request.getSession().removeAttribute("checkCode_Session");
        // 3.判断验证码是否正确,忽略大小写
        if ( checkCode_Session != null && checkCode_Session.equalsIgnoreCase(checkCode)) {
            // 如果正确
            // 正式代码
            // 1 获取参数
            Map<String, String[]> loginInfo = request.getParameterMap();
            // 2 创建userLogin对象
            User loginUser = new User();
            // 3 使用BeaUtils封装
            try {
                BeanUtils.populate(loginUser, loginInfo);
            } catch (
                    IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            UserDao userDao = new UserDao();
            User user = userDao.login(loginUser);

            if (user != null) {
                request.getSession().setAttribute("username", user.getUsername());
                response.sendRedirect("successful.jsp");
            } else {
                request.setAttribute("LOGIN_ERROR",ERROR_TIP.LOGIN);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else {
            // 验证码不一致
            request.setAttribute("CHECK_CODE_ERROR", ERROR_TIP.CHECK_CODE);
            // 转发
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}