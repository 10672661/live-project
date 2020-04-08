/**
 * 
 * @author Tiejiang
 *
 */
//定义实体类
public class Show {
	private String name;
	private Integer id ;
	private String entry_time;
	private String leave_time;
	public String getname(){
		return name;
	}
	public Integer getID(){
		return id;
	}
	public String getentry_time(){
		return entry_time;
	}
	public String getleave_time(){
		return leave_time;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setID(Integer id){
		this.id= id ;	
	}
	public void setentry(String entry_time){
		this.entry_time=entry_time;
	}
	public void setleave(String leave_time){
		this.leave_time= leave_time ;	
	}
	}
//网页显示

System.out.println("学号"+"姓名"+"进入时间"+"离开时间");


while(rs.next()){

	out.print(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));

	out.print("\n");//此处假设表中有四列数据

}
