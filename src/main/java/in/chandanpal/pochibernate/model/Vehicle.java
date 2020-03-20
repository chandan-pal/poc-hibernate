package in.chandanpal.pochibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="vehicle_table")
public class Vehicle {

	@Id
	private int vehicleId;
	private String vehicleName;
	
	//@ManyToOne
	//@NotFound(action=NotFoundAction.IGNORE)
	//@JoinColumn(name="owner") //many to one with mapped by
	//private UserDetails user;
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
	
}
