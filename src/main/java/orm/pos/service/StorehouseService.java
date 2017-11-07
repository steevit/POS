package orm.pos.service;

import java.util.List;

import orm.pos.entity.Storehouses;

public interface StorehouseService {

	public List<Storehouses> getStorehouses();
	
	public void saveStorehouse(Storehouses theStorehouse);

	public Storehouses getStorehouse(int theId);

	public void deleteStorehouse(int theId);
	
	public List<Storehouses> searchStorehouses(String theSearchName);

}
