package orm.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orm.pos.entity.Employees;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	//need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public List<Employees> getEmployees() {
			
			//get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			//create a query ... sort by last name
			Query<Employees> theQuery = currentSession.createQuery("from Employees order by id",
					Employees.class);
			
			//execute query and get result list
			List<Employees> employees = theQuery.getResultList();
			
			//return the results
			return employees;
		}

		@Override
		public void saveEmployee(Employees theEmployee) {
			
			//get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			//save the status
			currentSession.saveOrUpdate(theEmployee);
			
		}

		@Override
		public Employees getEmployee(int theId) {
			
			//get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			//now retrieve/read from database using the primary key
			Employees theEmployee = currentSession.get(Employees.class, theId);
			
			return theEmployee;
		}

		@Override
		public void deleteEmployee(int theId) {
			
			//get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			//delete object with primary key
			Query theQuery = 
					currentSession.createQuery("delete from Employees where id=:employeeId");
			theQuery.setParameter("employeeId", theId);
			
			theQuery.executeUpdate();
		}
		
		public List<Employees> searchEmployees(String theSearchName) {

	        // get the current hibernate session
	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        //
	        // only search by name if theSearchName is not empty
	        //
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            // search for firstName or lastName ... case insensitive
	            theQuery =currentSession.createQuery("from Employees where lower(fName) like :theName or lower(lName) like :theName", Employees.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery =currentSession.createQuery("from Employees", Employees.class);            
	        }
	        
	        // execute query and get result list
	        List<Employees> employees = theQuery.getResultList();
	                
	        // return the results        
	        return employees;
	        
	    }

}
