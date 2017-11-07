package orm.pos.dao;

import java.util.List;

import orm.pos.entity.Customers;

public interface CustomerDAO {

	public List<Customers> getCustomers();
	
	public void saveCustomer(Customers theCustomer);

	public Customers getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public List<Customers> searchCustomers(String theSearchName);
	
}
