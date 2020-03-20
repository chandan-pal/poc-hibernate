package in.chandanpal.pochibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class UserDetails {
	
	@Id
	private int userId;
	private String userName;
	
	//@OneToOne
	//@JoinColumn(name="vehicle_id") //not mandatory
	//private Vehicle vehicle;
	
	//one to many relationship
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_vehicles", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="vehicle_id"))
	private Collection<Vehicle> manyVehicles = new ArrayList<>();
	
	
	/*
	 * @Embedded
	 * 
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name="street", column=@Column(name="home_street")),
	 * 
	 * @AttributeOverride(name="city", column=@Column(name="home_city")),
	 * 
	 * @AttributeOverride(name="state", column=@Column(name="home_state")),
	 * 
	 * @AttributeOverride(name="pincode", column=@Column(name="home_pincode")) })
	 * private Address address;
	 */
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="user_address", joinColumns = @JoinColumn(name="user_id"))
	@GenericGenerator(name="sequencegen", strategy="sequence")
	@CollectionId(columns = { @Column(name="address_id") }, generator = "sequencegen", type = @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<>();
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	//	public Vehicle getVehicle() {
	//		return vehicle;
	//	}
	//	public void setVehicle(Vehicle vehicle) {
	//		this.vehicle = vehicle;
	//	}
	public Collection<Vehicle> getManyVehicles() {
		return manyVehicles;
	}
	public void setManyVehicles(Collection<Vehicle> manyVehicles) {
		this.manyVehicles = manyVehicles;
	}
	
	
}
