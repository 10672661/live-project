package ex1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public void class add(id,name) {


psql = con.prepareStatement("insert into test (xuehao,name,indate) "
        + "values(?,?,?)");
psql.setInt(1, id);              
psql.setString(2, name);     
 
DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
Date myDate2 = dateFormat2.parse("2020-04-08");
psql.setDate(3,new java.sql.Date(myDate2.getTime()));

psql.executeUpdate();           //Ö´ÐÐ¸üÐÂ

}