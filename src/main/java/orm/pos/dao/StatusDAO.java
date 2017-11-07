package orm.pos.dao;

import java.util.List;

import orm.pos.entity.Status;

public interface StatusDAO {

	public List<Status> getStatuses();
	
	public List<String> getStatusesName();
	
	public void saveStatus(Status theStatus);

	public Status getStatus(int theId);
	
	public Status getStatus(String theName);

	public void deleteStatus(int theId);
	
	public List<Status> searchStatus(String theSearchName);
	
}
