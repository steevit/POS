package orm.pos.dao;

import java.util.List;

import orm.pos.entity.Orders;

public interface OrderDAO {

	public List<Orders> getOrders();
	
	public void saveOrder(Orders theOrder);

	public Orders getOrder(int theId);
	
}
