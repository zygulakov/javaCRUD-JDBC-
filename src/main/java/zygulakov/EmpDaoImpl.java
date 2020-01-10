package zygulakov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpDaoImpl implements EmpDao {
	//Settings for this class to function
	private Settings set ;
	
	public EmpDaoImpl(Settings set) {
		this.set = set;
	}
	
	

	@Override
	public void add(Employee emp) {
		Connection conn = DriverManager.getConnection(set.getUrl(),set.getName(),set.getPassword());
		PreparedStatement st = conn.prepareStatement("INSERT INTO Employees (?,?,?)");
		st.setInt(1, emp.getEmpId());
		st.setString(2, emp.getName());
		st.setString(3, emp.getLastName());
		
	}

	@Override
	public boolean update(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee get(int eId) {
		// TODO Auto-generated method stub
		return null;
	}

}
