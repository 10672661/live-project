package com.juice.service;

import com.juice.dao.StudentDao;
import com.juice.domain.Student;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class StudentService {

    private StudentDao studentDao = new StudentDao();

    public List<Student> getStudent() throws SQLException {
        List<Student> allStudent = studentDao.getAllStudents();
        return allStudent;
    }

    public void addStudent(Student student) throws SQLException {
        // 调用DAO
        // 添加入校时间
        student.setEntry_time(new Date());
        studentDao.addStudent(student);
        
    }


}
