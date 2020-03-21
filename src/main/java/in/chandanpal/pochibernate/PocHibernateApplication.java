package in.chandanpal.pochibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.chandanpal.pochibernate.model.User;

@SpringBootApplication
public class PocHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocHibernateApplication.class, args);
		
		//HibernateBasics.runHiberNateBasics();
		
		//HibernateInheritance.runHiberNateInheritance();
		
		
		//Transient, Persistent, Detached objects
		User user = new User();
		user.setUserName("New User");  //user object is transient
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user); //user object is persistent, hibernate tracks for any changes in the object and saves that also in database.
		
		user.setUserName("Update user name"); //update not fired for this change
		user.setUserName("New updated user name"); //update fired for this change
		
		session.getTransaction().commit();
		session.close();
		
		//user object is detached at this point
		//hibernate is not tracking for changes in the object.
		user.setUserName("update after session close"); //this change is not saved in the database
	}

}
