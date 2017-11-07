package orm.pos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Embeddable
@Table(name="Orderitems")
public class OrderItemsID implements Serializable {

	@Column(name="order_id")
	private int orderId;
	
	@NotNull(message="Pole jest wymagane!")
	@Size(max=6, message="Maksymalnie 6 znaków!")
	@Pattern(regexp="[0-9]+", message="Tylko cyfry dozwolone!")
	@Column(name="product_id")
	private String productId;
	
	public OrderItemsID() {}

	public OrderItemsID(int orderId, String productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
