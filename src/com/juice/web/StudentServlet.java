package com.juice.web;

import com.juice.dao.StudentDao;
import com.juice.domain.Student;
import com.juice.service.StudentService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet {

    public String getListStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("StudentListServlet");
        // 调用服务层
        StudentDao studentDao = new StudentDao();
        try {
            List<Student> allStudents = studentDao.getAllStudents();
            System.out.println(studentDao);
            // 把数据写到request域
            request.setAttribute("allStudents", allStudents);
            // 转发
            return "main.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String addStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("AddServlet");
        // 1.获取所有参数   
        StudentService studentService = new StudentService();
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        // System.out.println(map);
        Student student = new Student();
        BeanUtils beanUtils = new BeanUtils();
        try {
            BeanUtils.populate(student, map);
            
            System.out.println(student);
            // 调用服务层
            
            studentService.addStudent(student);
            // 跳转列表 取最新数据
            return "StudentServlet?action=getListStudent";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }    
    
    public String updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("updateStudent");
        // 1.获取所有参数   
        StudentService studentService = new StudentService();
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        // System.out.println(map);
        Student student = new Student();
        BeanUtils beanUtils = new BeanUtils();
        try {
            BeanUtils.populate(student, map);
            
            System.out.println(student);
            // 调用服务层
            
            studentService.updateStudent(student);
            // 跳转列表 取最新数据
            return "StudentServlet?action=getListStudent";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
