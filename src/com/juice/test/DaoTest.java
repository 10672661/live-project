package com.juice.test;

import com.juice.dao.StudentDao;
import com.juice.domain.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DaoTest {
    
    @Test
    public void testDao() throws SQLException {
        StudentDao studentDao = new StudentDao();
        List<Student> allStudents = studentDao.getAllStudents();
        System.out.println(allStudents);
        
        Date d = allStudents.get(5).getEntry_time();
        System.out.println(d);
    }
    @Test
    public  void testAdd() throws SQLException {
        StudentDao studentDao = new StudentDao();
        Student student =new Student();
        student.setName("cc");
        student.setId(211706198);
        student.setEntry_time(new Date());
        studentDao.addStudent(student);
        
                
    }
    @Test
    public void testDate(){
        Date date = new Date();
        System.out.println(date);
    }
}
