package zygulakov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpDaoImpl implements EmpDao {
	// Settings for this class to function
	private Settings set;
	Connection conn;

	public EmpDaoImpl(Settings set) {
		this.set = set;
		try {
			conn = DriverManager.getConnection(set.getUrl(), set.getName(), set.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void add(Employee emp) {
		try {
			PreparedStatement st = conn.prepareStatement("INSERT INTO Employees VALUES (?,?,?,?)");
			st.setInt(1, emp.getEmpId());
			st.setString(2, emp.getName());
			st.setString(3, emp.getLastName());
			st.setString(4, emp.getCity());
			st.executeQuery();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong try again");
		}

	}

	@Override
	public void update(Employee emp) {

	}

	@Override
	public void remove(int i) {
		try {
			PreparedStatement st = conn.prepareStatement("DELETE FROM Employees WHERE EmpID = ?");
			st.setInt(1, i);
			
			st.executeUpdate();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong try again");
		}

	}

	@Override
	public Employee get(int id) {
		Employee em = null;
		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE EmpID = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			em = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(1));
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong try again");
		}
		return em;
	}

}
