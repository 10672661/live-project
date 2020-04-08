package ex1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex1 {
	public static void main(String[] args) throws IOException{
				Connection conn;
		         Statement stmt;
		         ResultSet rs;
		         String url = "jdbc:sqlserver://localhost:1433;DatabaseName=testdb;";
		         String sql = "select * from test1";
		         try {
		             // 连接数据库
		             conn = DriverManager.getConnection(url, "sa", "1314520");
		             // 建立Statement对象
		             stmt = conn.createStatement();
		             /**
		              * Statement createStatement() 创建一个 Statement 对象来将 SQL 语句发送到数据库。
		              */
		             // 执行数据库查询语句
		             rs = stmt.executeQuery(sql);
		             /**
		              * ResultSet executeQuery(String sql) throws SQLException 执行给定的 SQL
		              * 语句，该语句返回单个 ResultSet 对象
		             */
		             while (rs.next()) {
		                 int id = rs.getInt("xuehao");
		                 String name = rs.getString("name");
		                
		                 System.out.println("学号:" + id + "\tname:" + name );
		             }
		             if (rs != null) {
		                rs.close();
		                 rs = null;
		             }
		             if (stmt != null) {
		                 stmt.close();
		                 stmt = null;
		             }
		             if (conn != null) {
		                 conn.close();
		                 conn = null;
		            }
		         } catch (SQLException e) {
		            e.printStackTrace();
		             System.out.println("数据库连接失败");
		        }
		         add(id,name)
	}
}
public void class add(id,name) {


psql = con.prepareStatement("insert into test (xuehao,name,indate) "
        + "values(?,?,?)");
psql.setInt(1, id);              
psql.setString(2, name);     
 
DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
Date myDate2 = dateFormat2.parse("2020-04-08");
psql.setDate(3,new java.sql.Date(myDate2.getTime()));

psql.executeUpdate();           //执行更新

}