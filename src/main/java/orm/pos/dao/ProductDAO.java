package orm.pos.dao;

import java.util.List;

import orm.pos.entity.Products;

public interface ProductDAO {

	public List<Products> getProducts();
	
	public void saveProduct(Products theProduct);

	public Products getProduct(int theId);

	public void deleteProduct(int theId);
	
	public List<Products> searchProducts(String theSearchName);
	
}
