package orm.pos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Products")
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Size(max=50, message="Maksymalnie 50 znaków!")
	@NotNull(message="Pole jest wymagane!")
	@Column(name="name")
	private String name;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="category")
	private Categories category;
	
	@Pattern(regexp="^\\d+\\.+\\d{2}$", message="Z³y format!")
	@NotNull(message="Pole jest wymagane!")
	@Column(name="price")
	private String price;
	
	@Transient
	private String categoryName;


	public Products() {}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
