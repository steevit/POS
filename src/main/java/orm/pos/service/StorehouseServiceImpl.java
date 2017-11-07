package orm.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orm.pos.dao.StorehouseDAO;
import orm.pos.entity.Storehouses;

@Service
public class StorehouseServiceImpl implements StorehouseService {

		@Autowired
		private StorehouseDAO storehouseDAO;
		
		@Override
		@Transactional
		public List<Storehouses> getStorehouses() {
			return storehouseDAO.getStorehouses();
		}

		@Override
		@Transactional
		public void saveStorehouse(Storehouses theStorehouse) {
			storehouseDAO.saveStorehouse(theStorehouse);
		}

		@Override
		@Transactional
		public Storehouses getStorehouse(int theId) {
			return storehouseDAO.getStorehouse(theId);
		}

		@Override
		@Transactional
		public void deleteStorehouse(int theId) {
			storehouseDAO.deleteStorehouse(theId);
		}

		@Override
		@Transactional
		public List<Storehouses> searchStorehouses(String theSearchName) {

		    return storehouseDAO.searchStorehouses(theSearchName);
		}
	
}
