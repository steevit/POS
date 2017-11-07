package orm.pos.service;

import java.util.List;

import orm.pos.entity.Categories;

public interface CategoryService {

	public List<Categories> getCategories();
	
	public List<String> getCategoriesName();
	
	public void saveCategory(Categories theCategory);

	public Categories getCategory(int theId);
	
	public Categories getCategory(String theName);

	public void deleteCategory(int theId);
	
	public List<Categories> searchCategories(String theSearchName);
	
}
