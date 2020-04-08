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
        //URLָ��Ҫ���ʵ����ݿ�
        String url = "jdbc:mysql://localhost:3306/test";
        //MySQL����ʱ���û���
        String user = "root";
        //MySQL����ʱ������
        String password = "123123";
        //������ѯ�����
        try {
	        Class.forName(driver);            
	        //1.getConnection()����������MySQL���ݿ⣡��
	        con = DriverManager.getConnection(url,user,password);
	        if(!con.isClosed()) {
	            System.out.println("Succeeded connecting to the Database!");
	        }
	        //2.����statement���������ִ��SQL��䣡��
        }catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("�Ҳ���Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
	}
	public static void select(Connection c,String info) {
        //Ҫִ�е�SQL���
		Connection con = c;
		try {
			Statement statement = con.createStatement();
	        String sql = "select * from student where id = "+"'"+info+"'";
	        System.out.println(sql);
	        //3.ResultSet�࣬������Ż�ȡ�Ľ��������
	        ResultSet rs = statement.executeQuery(sql);
	        System.out.println("--------------------------------------");
	        System.out.println("ִ�н��������ʾ:");  
	        System.out.println("------------------------");  
	        System.out.println("ѧ��" + "\t" + "����" + "\t" + "����ʱ��" + "\t" + "�뿪ʱ��");  
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
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
	}
}
