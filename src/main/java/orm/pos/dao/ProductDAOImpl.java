package orm.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orm.pos.entity.Products;

@Repository
public class ProductDAOImpl implements ProductDAO {

		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public List<Products> getProducts() {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<Products> theQuery = currentSession.createQuery("from Products order by id",
					Products.class);
			
			List<Products> products = theQuery.getResultList();
			
			return products;
		}

		@Override
		public void saveProduct(Products theProduct) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			currentSession.saveOrUpdate(theProduct);
			
		}

		@Override
		public Products getProduct(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Products theProduct = currentSession.get(Products.class, theId);
			
			return theProduct;
		}

		@Override
		public void deleteProduct(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query theQuery = 
					currentSession.createQuery("delete from Products where id=:productId");
			theQuery.setParameter("productId", theId);
			
			theQuery.executeUpdate();
		}
		
		public List<Products> searchProducts(String theSearchName) {

	        Session currentSession = sessionFactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        if (theSearchName != null && theSearchName.trim().length() > 0) {

	            theQuery =currentSession.createQuery("from Products where lower(name) like :theName or lower(category.name) like :theName", Products.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            theQuery =currentSession.createQuery("from Products", Products.class);            
	        }
	        
	        List<Products> products = theQuery.getResultList();
	                        
	        return products;
	        
	    }

}
