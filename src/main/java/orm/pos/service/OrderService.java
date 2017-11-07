package orm.pos.service;

import java.util.List;

import orm.pos.entity.Orders;

public interface OrderService {

	public List<Orders> getOrders();
	
	public void saveOrder(Orders theOrder);

	public Orders getOrder(int theId);
	
}
