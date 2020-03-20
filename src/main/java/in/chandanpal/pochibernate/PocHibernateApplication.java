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

@SpringBootApplication
public class PocHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocHibernateApplication.class, args);
		
		//tests
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		
		Address address1 = new Address();
		address1.setCity("Pune");
		address1.setState("MH");
		
		Address address2 = new Address();
		address2.setCity("Dhanbad");
		address2.setState("JH");
		
		user.getListOfAddresses().add(address1);
		user.getListOfAddresses().add(address2);
		
		
		//create a session factory
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//----------------------saving object with hibernate api---------------------------------------------------------------------------
		
			//get session
			Session session = sessionFactory.openSession();
			
			//start transaction
			session.beginTransaction();
			
			//do operation
			session.save(user);
			
			//commit transaction
			session.getTransaction().commit();
			
			//close session
			session.close();
		
		
		//--------------------fething saved object with hibernate api---------------------------------------------------------------------------
		
			//get session
			session = sessionFactory.openSession();
			
			//start transaction
			session.beginTransaction();
			
			//fetch object
			UserDetails fetchedUser = (UserDetails) session.get(UserDetails.class, 1); //fetches the object which has the same primary key as the second argument
			System.out.println("fetched user name=" + fetchedUser.getUserName());
			
			//commit transaction
			session.getTransaction().commit();
			
			//close session
			session.close();
			
			//session closed - if default lazy fetch strategy is there for collection, this could have resulted in LazyInitializationError.
			System.out.println("fetched user addresses=" + fetchedUser.getListOfAddresses()); //with eager fetch strategy list of addresses are also fetched with UserDetails object.
	}

}
