package orm.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orm.pos.dao.PaymentDAO;
import orm.pos.entity.Payments;

@Service
public class PaymentServiceImpl implements PaymentService {

		@Autowired
		private PaymentDAO paymentDAO;
		
		@Override
		@Transactional
		public List<Payments> getPayments() {
			return paymentDAO.getPayments();
		}
		
		@Override
		@Transactional
		public List<String> getPaymentsName() {
			return paymentDAO.getPaymentsName();
		}

		@Override
		@Transactional
		public void savePayment(Payments thePayment) {
			paymentDAO.savePayment(thePayment);
		}

		@Override
		@Transactional
		public Payments getPayment(int theId) {
			return paymentDAO.getPayment(theId);
		}
		
		@Override
		@Transactional
		public Payments getPayment(String theName) {
			return paymentDAO.getPayment(theName);
		}

		@Override
		@Transactional
		public void deletePayment(int theId) {
			paymentDAO.deletePayment(theId);
		}
		
		@Override
		@Transactional
		public List<Payments> searchPayments(String theSearchName) {
			return paymentDAO.searchPayments(theSearchName);
		}
	
}
