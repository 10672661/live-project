/**
 * 
 * @author Tiejiang
 *
 */
//����ʵ����
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
//��ҳ��ʾ

System.out.println("ѧ��"+"����"+"����ʱ��"+"�뿪ʱ��");


while(rs.next()){

	out.print(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));

	out.print("\n");//�˴������������������

}
