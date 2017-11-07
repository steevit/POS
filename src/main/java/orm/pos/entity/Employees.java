package orm.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Employees")
public class Employees {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="Pole jest wymagane!")
	@Size(max=30, message="Maksymalnie 30 znaków!")
	@Column(name="f_name")
	private String fName;
	
	@NotNull(message="Pole jest wymagane!")
	@Size(max=30, message="Maksymalnie 30 znaków!")
	@Column(name="l_name")
	private String lName;
	
	@Size(max=40, message="Maksymalnie 40 znaków!")
	@Pattern(regexp=".+@.+\\..+", message="Niepoprawny email!")
	@Column(name="email")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
