package zygulakov;

public class Employee {
	private String name;
	private String lastName;
	private String city;
	private int empId;
	public Employee() {
		
	}
	public Employee(String name ,String lastName,String city,int empId) {
		this.name = name;
		this.lastName = lastName;
		this.city = city;
		this.empId = empId;
		
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	@Override
	public String toString() {
		return "Employee [name=" + name + ", lastName=" + lastName + ", city=" + city + ", empId=" + empId + "]";
	}
	
	
}
