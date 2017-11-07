package orm.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orm.pos.entity.Categories;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public List<Categories> getCategories() {
			
			//pobranie aktywnej sesji hibernate
			Session currentSession = sessionFactory.getCurrentSession();
			
			//stworzenie zapytania
			Query<Categories> theQuery = currentSession.createQuery("from Categories order by id",
					Categories.class);
			
			//wykonanie zapytania i pobranie wyników
			List<Categories> categories = theQuery.getResultList();
			
			//zwrócenie wyników
			return categories;
		}
		
		@Override
		public List<String> getCategoriesName() {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<String> theQuery = currentSession.createQuery("select name from Categories order by id");
			
			List<String> categories = theQuery.getResultList();
			
			return categories;
		}

		@Override
		public void saveCategory(Categories theCategory) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			//zapisanie (dodanie lub zaktualizowanie) kategorii
			currentSession.saveOrUpdate(theCategory);
			
		}

		@Override
		public Categories getCategory(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			//pobranie z bazy kategorii o danym id
			Categories theCategory = currentSession.get(Categories.class, theId);
			
			return theCategory;
		}
		
		@Override
		public Categories getCategory(String theName) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<Categories> theQuery = currentSession.createQuery("from Categories where lower(name) like :theName");
			theQuery.setParameter("theName", "%" + theName.toLowerCase() + "%");
			
			Categories theCategory = theQuery.getSingleResult();
			
			return theCategory;
		}

		@Override
		public void deleteCategory(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			//usuniêcie obiektu o danym id
			Query theQuery = 
					currentSession.createQuery("delete from Categories where id=:categoryId");
			theQuery.setParameter("categoryId", theId);
			
			theQuery.executeUpdate();
		}
		
		public List<Categories> searchCategories(String theSearchName) {

	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        //
	        // Szukaj tylko gdy parametr "theSearchName" nie jest pusty
	        //
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            theQuery =currentSession.createQuery("from Categories where lower(name) like :theName", Categories.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            // "theSearchName" jest pusty... wyszukaj wszystkie obiekty
	            theQuery =currentSession.createQuery("from Categories", Categories.class);            
	        }
	        
	        List<Categories> categories = theQuery.getResultList();
	                       
	        return categories;
	        
	    }

}
