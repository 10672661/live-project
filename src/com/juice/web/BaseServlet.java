package com.juice.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("TestServlet");
        String desPath = null;

        String action = request.getParameter("action");

        // 1.获取字节码
        try {
            Class clazz = this.getClass();
            Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 判断有没有传入的方法
            if (method != null) {
                // 使用当前对象调用
                desPath = (String) method.invoke(this, request, response);
            }
            // 转发
            if (desPath != null) {
                request.getRequestDispatcher(desPath).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

