package orm.pos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="Customers")
public class Customers {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="Pole jest wymagane!")
	@Size(max=30, message="Maksymalnie 30 znaków!")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message="Pole jest wymagane!")
	@Size(max=30, message="Maksymalnie 30 znaków!")
	@Column(name="last_name")
	private String lastName;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="details")
	private CustomerDetails details;
	
	public Customers() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerDetails getDetails() {
		return details;
	}

	public void setDetails(CustomerDetails details) {
		this.details = details;
	}
	
}
