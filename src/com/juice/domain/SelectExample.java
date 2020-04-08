package ex1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String info = sc.next();
		Connection c = link();
		select(c,info);
		
	}
	public static Connection link(){
		Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库
        String url = "jdbc:mysql://localhost:3306/test";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123123";
        //遍历查询结果集
        try {
	        Class.forName(driver);            
	        //1.getConnection()方法，连接MySQL数据库！！
	        con = DriverManager.getConnection(url,user,password);
	        if(!con.isClosed()) {
	            System.out.println("Succeeded connecting to the Database!");
	        }
	        //2.创建statement类对象，用来执行SQL语句！！
        }catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("找不到Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
	}
	public static void select(Connection c,String info) {
        //要执行的SQL语句
		Connection con = c;
		try {
			Statement statement = con.createStatement();
	        String sql = "select * from student where id = "+"'"+info+"'";
	        System.out.println(sql);
	        //3.ResultSet类，用来存放获取的结果集！！
	        ResultSet rs = statement.executeQuery(sql);
	        System.out.println("--------------------------------------");
	        System.out.println("执行结果如下所示:");  
	        System.out.println("------------------------");  
	        System.out.println("学号" + "\t" + "姓名" + "\t" + "进入时间" + "\t" + "离开时间");  
	        System.out.println("--------------------------------------");  
	        String name= null;
	        String id = null;
	        String enter = null;
	        String leave = null;
	        while(rs.next()){
	            id = rs.getString("id");
	            name = rs.getString("name");
	            enter = rs.getString("enterTime");
	            leave = rs.getString("leaveTime");
	            System.out.println(id + "\t" + name + "\t" + enter + "\t" + leave);
	        }
	        rs.close();
	        con.close();
		}catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
	}
}
