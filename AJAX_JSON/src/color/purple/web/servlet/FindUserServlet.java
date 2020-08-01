package color.purple.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提前设置了编码
        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");//在服务器端设置了响应格式

        // 正式代码
        // 1 获取用户
        String username = request.getParameter("username");
        System.out.println(username);
        Map<String,Object> msg = new HashMap<>();
        // 2 调用service层判断用户是否存在
        if ("tom".equals(username)) {
            // 存在
            msg.put("userExist",true);
            msg.put("msg","用户存在");
        } else {
            // 不存在
            msg.put("userExist",false);
            msg.put("msg","该用户可用");
        }

        // 将map转为json,并且传递到客户端
        ObjectMapper mapper = new ObjectMapper();
        // 将数据传递到客户端
        mapper.writeValue(response.getWriter(),msg);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
