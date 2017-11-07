package orm.pos.service;

import orm.pos.entity.OrderItems;
import orm.pos.entity.OrderItemsID;

public interface OrderItemService {
	
	public void saveOrderItem(OrderItems theOrderItem);

	public void deleteOrderItem(OrderItemsID theId);
	
}
