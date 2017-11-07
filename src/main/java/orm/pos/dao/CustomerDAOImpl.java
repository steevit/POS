package orm.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orm.pos.entity.Customers;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customers> getCustomers() {
		
		//pobranie aktywnej sesji hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		///stworzenie zapytania
		Query<Customers> theQuery = currentSession.createQuery("from Customers order by id",
				Customers.class);
		
		///wykonanie zapytania i pobranie wyników
		List<Customers> customers = theQuery.getResultList();
		
		//zwrócenie wyników
		return customers;
	}

	@Override
	public void saveCustomer(Customers theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//zapisanie (dodanie lub zaktualizowanie) klienta
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customers getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//pobranie z bazy klienta o danym id
		Customers theCustomer = currentSession.get(Customers.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//usuniêcie obiektu o danym id
		Customers theCustomer = this.getCustomer(theId);
		currentSession.delete(theCustomer);
	
	}
	
	public List<Customers> searchCustomers(String theSearchName) {

        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // Szukaj tylko gdy parametr "theSearchName" nie jest pusty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            theQuery =currentSession.createQuery("from Customers where lower(firstName) like :theName or lower(lastName) like :theName", Customers.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
        	// "theSearchName" jest pusty... wyszukaj wszystkie obiekty
            theQuery =currentSession.createQuery("from Customers", Customers.class);            
        }
        
        List<Customers> customers = theQuery.getResultList();
                        
        return customers;
        
    }

}
