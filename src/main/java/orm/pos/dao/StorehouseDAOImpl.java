package orm.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orm.pos.entity.Storehouses;

@Repository
public class StorehouseDAOImpl implements StorehouseDAO {

		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public List<Storehouses> getStorehouses() {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<Storehouses> theQuery = currentSession.createQuery("from Storehouses order by id",
					Storehouses.class);
			
			List<Storehouses> storehouses = theQuery.getResultList();
			
			return storehouses;
		}

		@Override
		public void saveStorehouse(Storehouses theStorehouse) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			currentSession.saveOrUpdate(theStorehouse);
			
		}

		@Override
		public Storehouses getStorehouse(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Storehouses theStorehouse = currentSession.get(Storehouses.class, theId);
			
			return theStorehouse;
		}

		@Override
		public void deleteStorehouse(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query theQuery = 
					currentSession.createQuery("delete from Storehouses where id=:storehouseId");
			theQuery.setParameter("storehouseId", theId);
			
			theQuery.executeUpdate();
		}
		
		public List<Storehouses> searchStorehouses(String theSearchName) {

	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            theQuery =currentSession.createQuery("from Storehouses where lower(name) like :theName or lower(city) like :theName", Storehouses.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            theQuery =currentSession.createQuery("from Storehouses", Storehouses.class);            
	        }
	        
	        List<Storehouses> storehouses = theQuery.getResultList();
	                        
	        return storehouses;
	        
	    }

}
