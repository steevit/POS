package orm.pos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orm.pos.entity.OrderItems;
import orm.pos.entity.OrderItemsID;

@Repository
public class OrderItemDAOImpl implements OrderItemDAO {

		@Autowired
		private SessionFactory sessionFactory;

		@Override
		public void saveOrderItem(OrderItems theOrderItem) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			currentSession.saveOrUpdate(theOrderItem);
			
		}

		@Override
		public void deleteOrderItem(OrderItemsID theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query theQuery = 
					currentSession.createQuery("delete from OrderItems where order_id=:orderId AND product_id=:productId");
			theQuery.setParameter("orderId", theId.getOrderId());
			theQuery.setParameter("productId", theId.getProductId());
			
			theQuery.executeUpdate();
		}
		
}
