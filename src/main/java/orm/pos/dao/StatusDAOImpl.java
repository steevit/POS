package orm.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orm.pos.entity.Status;

@Repository
public class StatusDAOImpl implements StatusDAO {

		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public List<Status> getStatuses() {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<Status> theQuery = currentSession.createQuery("from Status order by id",
					Status.class);
			
			List<Status> statuses = theQuery.getResultList();
			
			return statuses;
		}
		
		@Override
		public List<String> getStatusesName() {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<String> theQuery = currentSession.createQuery("select name from Status order by id");
			
			List<String> statuses = theQuery.getResultList();
			
			return statuses;
		}

		@Override
		public void saveStatus(Status theStatus) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			currentSession.saveOrUpdate(theStatus);
			
		}

		@Override
		public Status getStatus(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Status theStatus = currentSession.get(Status.class, theId);
			
			return theStatus;
		}
		
		@Override
		public Status getStatus(String theName) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<Status> theQuery = currentSession.createQuery("from Status where lower(name) like :theName");
			theQuery.setParameter("theName", "%" + theName.toLowerCase() + "%");
			
			Status theStatus = theQuery.getSingleResult();
			
			return theStatus;
		}

		@Override
		public void deleteStatus(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query theQuery = 
					currentSession.createQuery("delete from Status where id=:statusId");
			theQuery.setParameter("statusId", theId);
			
			theQuery.executeUpdate();
		}
		
		public List<Status> searchStatus(String theSearchName) {

	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            theQuery =currentSession.createQuery("from Status where lower(name) like :theName", Status.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            theQuery =currentSession.createQuery("from Status", Status.class);            
	        }
	        
	        List<Status> status = theQuery.getResultList();
	                        
	        return status;
	        
	    }

}
