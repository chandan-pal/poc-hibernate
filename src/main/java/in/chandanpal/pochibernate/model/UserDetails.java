package in.chandanpal.pochibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
	@Id
	private int userId;
	private String userName;
	
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
	
	@ElementCollection
	private Set<Address> listOfAddresses = new HashSet<>();
	
	
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
	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	} 
}
