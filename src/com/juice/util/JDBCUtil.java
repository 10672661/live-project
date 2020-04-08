package com.juice.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

public class JDBCUtil {

    public static DataSource ds = null;
    static {
        try {
            Properties p = new Properties();
            String path = JDBCUtil.class.getClassLoader().getResource("db.properties").getPath();
            FileInputStream in = new FileInputStream(path);
            p.load(in);

            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static DataSource getDataSource() {
        return ds;
    }
}
