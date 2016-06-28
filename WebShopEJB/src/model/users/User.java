package model.users;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import model.payment.Bill;
import model.users.buyers.BuyerCategory;

@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "findUserByUsername", query = "SELECT u FROM User u WHERE u.username LIKE :username")
public class User implements Serializable {
	private static final long serialVersionUID = -7746078774107447865L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String username; // unique
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Enumerated(EnumType.STRING)
	@Column(insertable = false, updatable = false, nullable = false)
	private Role role;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date registrationDate;

	// Buyer profile
	private String address;
	private double points;
	@ManyToOne(fetch = FetchType.EAGER)
	private BuyerCategory category;
	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Bill> paymentHistory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BuyerCategory getCategory() {
		return category;
	}

	public void setCategory(BuyerCategory category) {
		this.category = category;
	}

	public List<Bill> getPaymentHistory() {
		return paymentHistory;
	}

	public void setPaymentHistory(List<Bill> paymentHistory) {
		this.paymentHistory = paymentHistory;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

}
