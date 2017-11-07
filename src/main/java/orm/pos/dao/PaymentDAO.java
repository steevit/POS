package orm.pos.dao;

import java.util.List;

import orm.pos.entity.Payments;

public interface PaymentDAO {

	public List<Payments> getPayments();
	
	public List<String> getPaymentsName();
	
	public void savePayment(Payments thePayment);

	public Payments getPayment(int theId);
	
	public Payments getPayment(String theName);

	public void deletePayment(int theId);
	
	public List<Payments> searchPayments(String theSearchName);
	
}
