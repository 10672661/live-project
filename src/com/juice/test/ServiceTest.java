package com.juice.test;

import com.juice.dao.StudentDao;
import com.juice.domain.Student;
import com.juice.service.StudentService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ServiceTest {
    
    @Test
    public void testDao() throws SQLException {
        StudentService studentService = new StudentService();
        List<Student> student = studentService.getStudent();
        System.out.println(student);
    }
    @Test
    public  void testAdd() throws SQLException {
        StudentService studentService = new StudentService();
        
        Student student =new Student();
        student.setName("lz");
        student.setId(211706111);
        studentService.addStudent(student);
    }
}
