package orm.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orm.pos.dao.StatusDAO;
import orm.pos.entity.Status;

@Service
public class StatusServiceImpl implements StatusService {
	
		@Autowired
		private StatusDAO statusDAO;
		
		@Override
		@Transactional
		public List<Status> getStatuses() {
			return statusDAO.getStatuses();
		}
		
		@Override
		@Transactional
		public List<String> getStatusesName() {
			return statusDAO.getStatusesName();
		}

		@Override
		@Transactional
		public void saveStatus(Status theStatus) {
			statusDAO.saveStatus(theStatus);
		}

		@Override
		@Transactional
		public Status getStatus(int theId) {
			return statusDAO.getStatus(theId);
		}
		
		@Override
		@Transactional
		public Status getStatus(String theName) {
			return statusDAO.getStatus(theName);
		}

		@Override
		@Transactional
		public void deleteStatus(int theId) {
			statusDAO.deleteStatus(theId);
		}
		
		@Override
		@Transactional
		public List<Status> searchStatus(String theSearchName) {
			return statusDAO.searchStatus(theSearchName);
		}
	
}
