package zygulakov;

import java.sql.ResultSet;

public class App {
	public static void main(String[] args)throws Exception {
		System.out.println("checking settings getting ready...");
		Json json = new Json();
		System.out.println("OK connection established!");
		System.out.println("pls enter \"-h\" for help");
		EmpDao em = new EmpDaoImpl(json.getSettings());
		Employee emp = em.get(1);
		em.remove(1);
		System.out.println(emp); 
		
		
		/*
		 * String url = "jdbc:mysql://localhost:3306/test"; String name = "zy"; String
		 * pass = "123"; ResultSet rs = Data.connect(url, name, pass); rs.next();
		 * System.out.println(rs.getString(1));
		 */

	}
}
