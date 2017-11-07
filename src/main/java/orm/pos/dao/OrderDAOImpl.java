package orm.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orm.pos.entity.OrderItems;
import orm.pos.entity.Orders;

@Repository
public class OrderDAOImpl implements OrderDAO {

		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public List<Orders> getOrders() {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<Orders> theQuery = currentSession.createQuery("from Orders order by id DESC",
					Orders.class);
			
			List<Orders> orders = theQuery.getResultList();
			
			//pobranie produktów do ka¿dego pobranego zamówienia
			for(Orders x : orders) {
				Query theQuery2 = currentSession.createQuery("from OrderItems where order_id like :theId");
				theQuery2.setParameter("theId", "%" + x.getId() + "%");
				List<OrderItems> theItems = theQuery2.getResultList();
				x.setItems(theItems);
				double total=0.00;
				for(OrderItems tempOrderItem : x.getItems()) {
					double price = Double.parseDouble(tempOrderItem.getPrice());
					Integer quantity = Integer.parseInt(tempOrderItem.getQuantity());
					total = total+(price*quantity);
				}
				x.setTotal(String.format("%.2f",total));
			}
			
			
			return orders;
		}

		@Override
		public void saveOrder(Orders theOrder) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			currentSession.saveOrUpdate(theOrder);
			
		}

		@Override
		public Orders getOrder(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Orders theOrder = currentSession.get(Orders.class, theId);
			
			return theOrder;
		}

}
