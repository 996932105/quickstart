package com.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author mqxu
 * @date 2019.9.17
 * 登陆请求响应
 */
@WebServlet(urlPatterns = "/login.do")
public class Loginservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求乱码
        req.setCharacterEncoding("UTF-8");
    String username = req.getParameter("username");

        System.out.printf(username);
        //跳转之前把用户名存入req对象
        req.setAttribute("username",username);
        //通过req跳转
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

        //通过req请求对象获取session会话对象
        HttpSession session = req.getSession();

        session.setAttribute("username",username);
        //通过resp跳转
        resp.sendRedirect("/index.jsp");

    }

    public static void main(String[] args) {
        System.out.printf("aaa");
    }

}
