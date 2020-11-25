package adapter;


import holder.studentParameter;
import holder.studentParameter.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import adapter.CaeserCipher;


public class studentMethods {

	
public static int save(studentParameter bean){
	int status=0;
	try{
		Connection con=Database.getCon();
		
		PreparedStatement ps=con.prepareStatement("insert into student(name,email,course,gender,address,contact) values(?,?,?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());	
		ps.setString(4,bean.getCourse());
		ps.setString(3,bean.getgender());
		ps.setString(5,bean.getAddress());
		ps.setString(6,bean.getcontact());
		
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static int update(studentParameter bean){
	int status=0;
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("update student set name=?,email=?,course=?,gender=?,address=?,contact=? where id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getgender());
		ps.setString(4,bean.getCourse());
	
		ps.setString(5,bean.getAddress());
		ps.setString(6,bean.getcontact());
		ps.setInt(7,bean.getRollno());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}	
public static int delete(int rollno){
	int status=0;
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("delete from fee where F_id=?");
		ps.setInt(1,rollno);
		status=ps.executeUpdate();
		PreparedStatement ps2=con.prepareStatement("delete from student where id=?");
		ps2.setInt(1,rollno);
		status=ps2.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static int deleteByName(String name){
	int status=0;
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("delete from student where name=?");
		ps.setString(1,name);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static List<studentParameter> getAllRecords(){
	List<studentParameter> list=new ArrayList<studentParameter>();
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from student");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			studentParameter bean=new studentParameter();
			bean.setRollno(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			//bean.setgender(CaeserCipher.decrypt(rs.getString(4),3));
			bean.setgender(rs.getString(4));

			bean.setCourse(rs.getString(5));
			
			bean.setAddress(rs.getString(6));
			bean.setcontact(rs.getString(7));
			bean.setFee(rs.getInt(8));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}
public static List<studentParameter> getDues(){
	List<studentParameter> list=new ArrayList<studentParameter>();
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from student where due>0");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			studentParameter bean=new studentParameter();
			bean.setRollno(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setgender(rs.getString(4));
			bean.setCourse(rs.getString(5));
		
			bean.setAddress(rs.getString(6));
			bean.setcontact(rs.getString(7));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}

public static studentParameter getRecorDatabaseyRollno(int rollno){
	studentParameter bean=new studentParameter();
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from student where rollno=?");
		ps.setInt(1,rollno);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setRollno(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setgender(rs.getString(4));
			bean.setCourse(rs.getString(5));         
		
			bean.setAddress(rs.getString(6));
			bean.setcontact(rs.getString(7));
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return bean;
}
public static boolean validate(String email,String password){
	boolean status=false;
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from student where email=? AND id=? ");
		ps.setString(1,email);
		ps.setString(2,password);

		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static void getMax()
{
	int j=0;
	try
	{

		Connection con=Database.getCon();
		PreparedStatement ps2=con.prepareStatement("select MAX(id) from student");
		ResultSet rs=ps2.executeQuery();
		while(rs.next()){
			 j=rs.getInt(1);
		}
	}
	catch(Exception e)
	{
		
	}
}



}
