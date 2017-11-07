package orm.pos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Orderitems")
public class OrderItems {

	@EmbeddedId
	private OrderItemsID id;
	
	@NotNull(message="Pole jest wymagane!")
	@Size(max=5, message="Maksymalnie 5 cyfr!")
	@Pattern(regexp="[0-9]+", message="Tylko cyfry dozwolone!")
	@Column(name="quantity")
	private String quantity;

	@Valid
	public OrderItemsID getId() {
		return id;
	}
	
	@MapsId("id")
	@ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="order_id")
	private Orders order;
	
	@MapsId("id")
	@ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Products product;
	
	@Transient
	private int orderId;

	public void setId(OrderItemsID id) {
		this.id = id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product=product;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getPrice()
	{ 
		return product.getPrice();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
}
