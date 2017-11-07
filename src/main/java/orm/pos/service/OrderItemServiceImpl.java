package orm.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orm.pos.dao.OrderItemDAO;
import orm.pos.entity.OrderItems;
import orm.pos.entity.OrderItemsID;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDAO orderItemDAO;

	@Override
	@Transactional
	public void saveOrderItem(OrderItems theOrderItem) {
		orderItemDAO.saveOrderItem(theOrderItem);
	}

	@Override
	@Transactional
	public void deleteOrderItem(OrderItemsID theId) {
		orderItemDAO.deleteOrderItem(theId);
	}
	
}
