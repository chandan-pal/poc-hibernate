package in.chandanpal.pochibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.chandanpal.pochibernate.model.Address;
import in.chandanpal.pochibernate.model.UserDetails;
import in.chandanpal.pochibernate.model.Vehicle;

@SpringBootApplication
public class PocHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocHibernateApplication.class, args);
		
		//tests
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("FirstUser");
		
		Address address1 = new Address();
		address1.setCity("Pune");
		address1.setState("MH");
		
		Address address2 = new Address();
		address2.setCity("Dhanbad");
		address2.setState("JH");
		
		user.getListOfAddresses().add(address1);
		user.getListOfAddresses().add(address2);
		
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleId(1);
		vehicle1.setVehicleName("Vehicle Name 1");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleId(2);
		vehicle2.setVehicleName("Vehicle Name 2");

		//user.setVehicle(vehicle1);  //one to one
		
		//one to many
		user.getManyVehicles().add(vehicle1);
		user.getManyVehicles().add(vehicle2);
		
		//many to one
		//vehicle1.setUser(user);
		//vehicle2.setUser(user);
		
		
		//create a session factory
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//----------------------saving object with hibernate api---------------------------------------------------------------------------
		
			//get session
			Session session = sessionFactory.openSession();
			
			//start transaction
			session.beginTransaction();
			
			//do operation
			session.save(user);
			//session.save(vehicle1);
			
			//commit transaction
			session.getTransaction().commit();
			
			//close session
			session.close();
		
		
		//--------------------fetching saved object with hibernate api---------------------------------------------------------------------------
		
			//get session
			session = sessionFactory.openSession();
			
			//start transaction
			session.beginTransaction();
			
			//fetch object
			UserDetails fetchedUser = (UserDetails) session.get(UserDetails.class, 1); //fetches the object which has the same primary key as the second argument
			System.out.println("fetched user name=" + fetchedUser.getUserName());
			System.out.println("fetched vehicles=" + fetchedUser.getManyVehicles());
			
			//commit transaction
			session.getTransaction().commit();
			
			//close session
			session.close();
	}

}
