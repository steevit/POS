package orm.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orm.pos.dao.OrderDAO;
import orm.pos.entity.Orders;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	@Transactional
	public List<Orders> getOrders() {
		return orderDAO.getOrders();
	}

	@Override
	@Transactional
	public void saveOrder(Orders theOrder) {
		orderDAO.saveOrder(theOrder);
	}

	@Override
	@Transactional
	public Orders getOrder(int theId) {
		return orderDAO.getOrder(theId);
	}

}
