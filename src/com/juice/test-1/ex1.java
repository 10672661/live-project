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
		             // �������ݿ�
		             conn = DriverManager.getConnection(url, "sa", "1314520");
		             // ����Statement����
		             stmt = conn.createStatement();
		             /**
		              * Statement createStatement() ����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
		              */
		             // ִ�����ݿ��ѯ���
		             rs = stmt.executeQuery(sql);
		             /**
		              * ResultSet executeQuery(String sql) throws SQLException ִ�и����� SQL
		              * ��䣬����䷵�ص��� ResultSet ����
		             */
		             while (rs.next()) {
		                 int id = rs.getInt("xuehao");
		                 String name = rs.getString("name");
		                
		                 System.out.println("ѧ��:" + id + "\tname:" + name );
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
		             System.out.println("���ݿ�����ʧ��");
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

psql.executeUpdate();           //ִ�и���

}