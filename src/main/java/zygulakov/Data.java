package zygulakov;

import java.sql.*;
public class Data {
	public static ResultSet connect(String url,String name,String pass) throws Exception {
		 //Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection(url,name,pass);
		 Statement st = conn.createStatement();
		 return st.executeQuery("select * from Employees");
		 
	}
}
