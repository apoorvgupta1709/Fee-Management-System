package adapter;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://mysql80-afe9.euw2.cloud.ametnes.com:3316/5526447359?verifyServerCertificate=false&useSSL=true","yyULNskXcg","N9Lp053SpkSN4VNasjgc");
		}catch(Exception ex){System.out.println(ex);}
		return con;
	}

}
