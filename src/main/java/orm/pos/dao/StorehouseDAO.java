package orm.pos.dao;

import java.util.List;

import orm.pos.entity.Storehouses;

public interface StorehouseDAO {

	public List<Storehouses> getStorehouses();
	
	public void saveStorehouse(Storehouses theStorehouse);

	public Storehouses getStorehouse(int theId);

	public void deleteStorehouse(int theId);
	
	public List<Storehouses> searchStorehouses(String theSearchName);
	
}
