package in.chandanpal.pochibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.chandanpal.pochibernate.model.User;

public class CriteriaAPI {

	public static void run() {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//get criteria builder
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		//create criteria for an entity
		CriteriaQuery<User> criteria = cb.createQuery(User.class);  
		
		//set the root
		Root<User> root = criteria.from(User.class);
		
		//set selects and criterion
		criteria.select(root); //set selects
//		criteria.select(root.get("userName")); //selects only userName field
		criteria.where(cb.equal(root.get("userName"), "User With Where"));
		
		//execute the query
		List userList = session.createQuery(criteria).getResultList();
		
		System.out.println("users = " + userList);
		
		session.getTransaction().commit();
		session.close();
	}

}
