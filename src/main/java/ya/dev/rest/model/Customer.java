package ya.dev.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findByActive", query="SELECT c FROM Customer c WHERE c.active =:active")
public class Customer implements Serializable{

	private static final long serialVersionUID = 8211137201812964421L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=100)
	private String lastname;
	
	@Column(length=100)
	private String firstname;
	
	@Column(length=200)
	private String company;
	
	@Column(length=255)
	private String mail;
	
	@Column(length=15)
	private String phone;
	
	@Column(length=15)
	private String mobile;
	
	@Column(columnDefinition = "TEXT")
	private String notes;
	
	@Column
	private Boolean active;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	List<Order>orders;
	
	public Customer() {
		super();
	}

	public Customer(Integer id, String lastname, String firstname, String company, String mail, String phone,
			String mobile, String notes, Boolean active) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.company = company;
		this.mail = mail;
		this.phone = phone;
		this.mobile = mobile;
		this.notes = notes;
		this.active = active;
	}
	
	public Customer(CustomerBuilder customerBuilder) {
		super();
		this.id = customerBuilder.id;
		this.lastname = customerBuilder.lastname;
		this.firstname = customerBuilder.firstname;
		this.company = customerBuilder.company;
		this.mail = customerBuilder.mail;
		this.phone = customerBuilder.phone;
		this.mobile = customerBuilder.mobile;
		this.notes = customerBuilder.notes;
		this.active = customerBuilder.active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", company=" + company
				+ ", mail=" + mail + ", phone=" + phone + ", mobile=" + mobile + ", notes=" + notes + ", active="
				+ active + "]";
	}

	// Builder class
	public static class CustomerBuilder {
		private Integer id;
		private String lastname;
		private String firstname;
		private String company;
		private String mail;
		private String phone;
		private String mobile;
		private String notes;
		private Boolean active = false;
		
		
		

		public CustomerBuilder setId(Integer id) {
			this.id = id;
			return this;
		}

		public CustomerBuilder setLastname(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public CustomerBuilder setFirstname(String firstname) {
			this.firstname = firstname;
			return this;
		}

		public CustomerBuilder setCompany(String company) {
			this.company = company;
			return this;
		}

		public CustomerBuilder setMail(String mail) {
			this.mail = mail;
			return this;
		}

		public CustomerBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public CustomerBuilder setMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public CustomerBuilder setNotes(String notes) {
			this.notes = notes;
			return this;
		}

		public CustomerBuilder setActive(Boolean active) {
			this.active = active;
			return this;
		}
		
		public Customer build() {
			return new Customer(this);
		}
		
	}
	
	
}
