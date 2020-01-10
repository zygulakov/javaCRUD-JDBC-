package zygulakov;

public class Employee {
	private String name;
	private String lastName;
	private int empId;
	public Employee() {
		
	}
	public Employee(String name ,String lastName,int empId) {
		this.name = name;
		this.lastName = lastName;
		this.empId = empId;
		
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
}
