package orm.pos.dao;

import java.util.List;

import orm.pos.entity.Employees;

public interface EmployeeDAO {

	public List<Employees> getEmployees();
	
	public void saveEmployee(Employees theEmployee);

	public Employees getEmployee(int theId);

	public void deleteEmployee(int theId);
	
	public List<Employees> searchEmployees(String theSearchName);
	
}
