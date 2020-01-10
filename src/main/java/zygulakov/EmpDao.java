package zygulakov;

public interface EmpDao {
	boolean create(Employee emp);
	boolean update(Employee emp);
	boolean remove(Employee emp);
	Employee get(String name);
	Employee get(int eId);
	

}
