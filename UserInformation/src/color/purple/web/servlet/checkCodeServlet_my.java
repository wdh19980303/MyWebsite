package color.purple.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

//@WebServlet("/checkCodeServlet")
public class checkCodeServlet_my extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int width = 100;
        final int height = 50;

        // 1 创建一张图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 2 美化图片
        // 2.1 填充背景色
        Graphics g = image.createGraphics();
        Graphics2D graphics2D = image.createGraphics();
        // 设置字体
        g.setFont(new Font("Source Code Pro",Font.BOLD,30));
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);
        // 2.2 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        // 生成随机角标
        Random randomIndex = new Random();
        StringBuilder sb = new StringBuilder(); //接收字符

        // 2.3 画验证码
        for (int i = 1; i <= 4; i++) {

            int index = randomIndex.nextInt(str.length());
            char C = str.charAt(index);
            sb.append(C);
            g.drawString(C + "", (width / 5) * i - 10, 35);
        }

        // 验证码
        String checkCode_Session = sb.toString();
        request.getSession().setAttribute("checkCode_Session",checkCode_Session);


        // 2.4 画干扰线
        // 随机生成坐标点

        for (int i = 0; i < 4; i++) {
            int x1 = randomIndex.nextInt(width);
            int x2 = randomIndex.nextInt(width);
            int y1 = randomIndex.nextInt(height);
            int y2 = randomIndex.nextInt(height);
            g.setColor(Color.green);
            g.drawLine(x1,y1,x2,y2);
        }



        // 3 将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
