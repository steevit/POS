package orm.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orm.pos.dao.EmployeeDAO;
import orm.pos.entity.Employees;

@Service
public class EmployeeServiceImpl implements EmployeeService {

		@Autowired
		private EmployeeDAO employeeDAO;
		
		@Override
		@Transactional
		public List<Employees> getEmployees() {
			return employeeDAO.getEmployees();
		}

		@Override
		@Transactional
		public void saveEmployee(Employees theEmployee) {
			employeeDAO.saveEmployee(theEmployee);
		}

		@Override
		@Transactional
		public Employees getEmployee(int theId) {
			return employeeDAO.getEmployee(theId);
		}

		@Override
		@Transactional
		public void deleteEmployee(int theId) {
			employeeDAO.deleteEmployee(theId);
		}

		@Override
		@Transactional
		public List<Employees> searchEmployees(String theSearchName) {

		    return employeeDAO.searchEmployees(theSearchName);
		}
	
}
