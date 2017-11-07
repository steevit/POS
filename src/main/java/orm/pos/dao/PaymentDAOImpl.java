package orm.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orm.pos.entity.Payments;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public List<Payments> getPayments() {
			
			Session currentSession = sessionFactory.getCurrentSession();

			Query<Payments> theQuery = currentSession.createQuery("from Payments order by id",
					Payments.class);
			
			List<Payments> payments = theQuery.getResultList();
			
			return payments;
		}
		
		@Override
		public List<String> getPaymentsName() {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<String> theQuery = currentSession.createQuery("select name from Payments order by id");
			
			List<String> payments = theQuery.getResultList();
			
			return payments;
		}

		@Override
		public void savePayment(Payments thePayment) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			currentSession.saveOrUpdate(thePayment);
			
		}

		@Override
		public Payments getPayment(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Payments thePayment = currentSession.get(Payments.class, theId);
			
			return thePayment;
		}
		
		@Override
		public Payments getPayment(String theName) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<Payments> theQuery = currentSession.createQuery("from Payments where lower(name) like :theName");
			theQuery.setParameter("theName", "%" + theName.toLowerCase() + "%");
			
			Payments thePayment = theQuery.getSingleResult();
			
			return thePayment;
		}

		@Override
		public void deletePayment(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query theQuery = 
					currentSession.createQuery("delete from Payments where id=:paymentId");
			theQuery.setParameter("paymentId", theId);
			
			theQuery.executeUpdate();
		}
		
		public List<Payments> searchPayments(String theSearchName) {

	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            theQuery =currentSession.createQuery("from Payments where lower(name) like :theName", Payments.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            theQuery =currentSession.createQuery("from Payments", Payments.class);            
	        }
	        
	        List<Payments> payments = theQuery.getResultList();
	                        
	        return payments;
	        
	    }

}
