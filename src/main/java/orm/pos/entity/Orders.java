package orm.pos.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Orders")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="customer")
	private Customers customer;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="status")
	private Status status;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="payment")
	private Payments payment;
	
	@Transient
	private List<OrderItems> items;
	
	@Transient
	private String total;
	
	@Transient
	private int customerID;
	
	@Transient
	private String statusName;
	
	@Transient
	private String paymentName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}

	public List<OrderItems> getItems() {
		return items;
	}

	public void setItems(List<OrderItems> items) {
		this.items = items;
	}
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	
	/*public String getTotal() {
		double total=0.00;
		for(OrderItems tempOrder : items) {
			double price = Double.parseDouble(tempOrder.getPrice());
			Integer quantity = Integer.parseInt(tempOrder.getQuantity());
			total = total+(price*quantity);
		}
		String totalS = String.format("%.2f",total);
		return totalS;
	}*/
	
}
