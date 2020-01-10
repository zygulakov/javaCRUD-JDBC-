package zygulakov;

import java.util.List;

public interface EmpDao {
	void add(Employee emp);
	void update(Employee emp);
	void remove(int id);
	Employee get(int eId);
	List<Employee> getAll();
	

}
