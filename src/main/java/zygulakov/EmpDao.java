package zygulakov;

import java.util.List;

public interface EmpDao {
	void add(Employee emp);
	void remove(int... ids);
	Employee get(int eId);
	List<Employee> getAll();
	

}
