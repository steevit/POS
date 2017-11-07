package orm.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Customer_details")
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Size(max=40, message="Maksymalnie 40 znaków!")
	@Pattern(regexp=".+@.+\\..+", message="Niew³aœciwy email!")
	@Column(name="email")
	private String email;
	
	@Size(min=9, max=13, message="Dozwolone 9-13 cyfr!")
	@Pattern(regexp="[0-9]+", message="Tylko cyfry dozwolone!")
	@Column(name="phone")
	private String phone;
	
	@Size(max=30, message="Maksymalnie 30 znaków!")
	@Column(name="street")
	private String street;
	
	@Pattern(regexp="^\\d{2}-\\d{3}$", message="Z³y format!")
	@Column(name="zip")
	private String zip;
	
	@Size(max=30, message="Maksymalnie 30 znaków!")
	@Column(name="city")
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
