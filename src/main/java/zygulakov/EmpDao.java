package zygulakov;

public interface EmpDao {
	void add(Employee emp);
	void update(Employee emp);
	void remove(Employee emp);
	Employee get(String name);
	Employee get(int eId);
	

}
