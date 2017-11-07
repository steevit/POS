package orm.pos.dao;

import orm.pos.entity.OrderItems;
import orm.pos.entity.OrderItemsID;

public interface OrderItemDAO {
	
	public void saveOrderItem(OrderItems theOrderItem);

	public void deleteOrderItem(OrderItemsID theId);
	
}
