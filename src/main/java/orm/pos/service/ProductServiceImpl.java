package orm.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orm.pos.dao.ProductDAO;
import orm.pos.entity.Products;

@Service
public class ProductServiceImpl implements ProductService {

		@Autowired
		private ProductDAO productDAO;
		
		@Override
		@Transactional
		public List<Products> getProducts() {
			return productDAO.getProducts();
		}

		@Override
		@Transactional
		public void saveProduct(Products theProduct) {
			productDAO.saveProduct(theProduct);
		}

		@Override
		@Transactional
		public Products getProduct(int theId) {
			return productDAO.getProduct(theId);
		}

		@Override
		@Transactional
		public void deleteProduct(int theId) {
			productDAO.deleteProduct(theId);
		}

		@Override
		@Transactional
		public List<Products> searchProducts(String theSearchName) {

		    return productDAO.searchProducts(theSearchName);
		}
	
}
