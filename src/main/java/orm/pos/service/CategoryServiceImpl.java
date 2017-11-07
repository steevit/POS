package orm.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orm.pos.dao.CategoryDAO;
import orm.pos.entity.Categories;

@Service
public class CategoryServiceImpl implements CategoryService {

		@Autowired
		private CategoryDAO categoryDAO;
		
		@Override
		@Transactional
		public List<Categories> getCategories() {
			return categoryDAO.getCategories();
		}
		
		@Override
		@Transactional
		public List<String> getCategoriesName() {
			return categoryDAO.getCategoriesName();
		}

		@Override
		@Transactional
		public void saveCategory(Categories theCategory) {
			categoryDAO.saveCategory(theCategory);
		}

		@Override
		@Transactional
		public Categories getCategory(int theId) {
			return categoryDAO.getCategory(theId);
		}
		
		@Override
		@Transactional
		public Categories getCategory(String theName) {
			return categoryDAO.getCategory(theName);
		}

		@Override
		@Transactional
		public void deleteCategory(int theId) {
			categoryDAO.deleteCategory(theId);
		}

		@Override
		@Transactional
		public List<Categories> searchCategories(String theSearchName) {

		    return categoryDAO.searchCategories(theSearchName);
		}
	
}
