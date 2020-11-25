package adapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import holder.accountantParameter;

public class accountantMethods {

	
public static int save(accountantParameter bean){
	int status=0;
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("insert into accountant(name,email,gender,mobile) values(?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getgender());
		ps.setString(4,bean.getContact());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static boolean validate(String email,String password){
	boolean status=false;
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from accountant where email=? AND id=? ");
		ps.setString(1,email);
		ps.setString(2,password);

		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static int update(accountantParameter bean){
	int status=0;
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("update accountant set name=?,email=?,address=?,mobile=? where id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(4,bean.getgender());
		ps.setString(5,bean.getContact());
		ps.setInt(6,bean.getId());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}	

public static int delete(int id){
	int status=0;
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("delete from accountant where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static List<accountantParameter> getAllRecords(){
	List<accountantParameter> list=new ArrayList<accountantParameter>();
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from accountant");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			accountantParameter bean=new accountantParameter();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setgender(rs.getString(5));
			bean.setContact(rs.getString(6));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}

public static accountantParameter getRecorDatabaseyId(int id){
	accountantParameter bean=new accountantParameter();
	try{
		Connection con=Database.getCon();
		PreparedStatement ps=con.prepareStatement("select * from accountant where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setgender(rs.getString(5));
			bean.setContact(rs.getString(6));
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return bean;
}
}
