package zygulakov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
	// Settings for this class to function
	Connection conn;

	// Settings object for connecting to database
	public EmpDaoImpl(Settings set) {
		try {
			conn = DriverManager.getConnection(set.getUrl(), set.getName(), set.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	// adding Employee object to database
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
			//e.printStackTrace();
			System.out.println("there is already exist same id use unique id");
		}

	}


	@Override
	// removing data from database by ID if exist
	public void remove(int... ids ) {
		
		try {
			// check whether the data exist
			Statement s = conn.createStatement();
			// returns false if no such data exist
			for (int id : ids) {
				
			boolean exist = s.executeQuery("SELECT * FROM Employees WHERE EmpID = " + id).next();
			if (!exist) {
				System.out.println("No such ID :"+id);
				return;
			}
			PreparedStatement st = conn.prepareStatement("DELETE FROM Employees WHERE EmpID = ?");
			st.setInt(1, id);
			st.executeUpdate();
			}
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong try again");
		}

	}

	@Override
	public Employee get(int id) {
		Employee em = null;
		System.out.println("getting Employee by id: " + id);
		try {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE EmpID = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			// to check whether the data exist
			if (rs.next()) {
				em = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(1));
				System.out.println("Done!");

			} else
				System.out.println("There is no any Employee by this id sorry");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("something went wrong try again");
		}
		return em;
	}

	@Override
	// fetching all data as Employee objects ,returning as List of objects
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Employees");
			while (rs.next()) {
				Employee em = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(1));
				emps.add(em);

			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return emps;
	}

}
