package com.juice.dao;

import com.juice.domain.Student;
import com.juice.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

    // 查询
    public List<Student> getAllStudents() throws SQLException {
        String sql = "select * from student";
        List<Student> allStudents = qr.query(sql, new BeanListHandler<Student>(Student.class));
        return allStudents;
    }

    // 添加
    public void addStudent(Student student) throws SQLException {
        String sql = "insert into student (name,id,entry_time,leave_time) value (?,?,?,?)";


        qr.update(sql, student.getName(), student.getId(), student.getEntry_time(), student.getLeave_time());
    }


}
