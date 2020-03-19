package in.chandanpal.pochibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.chandanpal.pochibernate.model.UserDetails;

@SpringBootApplication
public class PocHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocHibernateApplication.class, args);
		
		//tests
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("FirstUser");
		
		//create a session factory
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//get session
		Session session = sessionFactory.openSession();
		
		//start transaction
		session.beginTransaction();
		
		//do operation
		session.save(user);
		
		//commit transaction
		session.getTransaction().commit();
	}

}
