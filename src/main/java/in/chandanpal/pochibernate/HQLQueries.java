package in.chandanpal.pochibernate;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLQueries {
	

	public static void run() {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//create query object
//		Query hibernateQuery = session.createQuery("from User"); //select * from User(class name) entity
//		Query hibernateQuery = session.createQuery("select userName from User"); //select userName(field name) from User(class name) entity
		Query hibernateQuery = session.createQuery("select new map(userName, userId) from User"); //return a map for each object conitaining the fields
		hibernateQuery.setMaxResults(2); //set the maximum number of record in one go
		hibernateQuery.setFirstResult(3); //set the start position
		Query hibernateQueryWithWhere = session.createQuery("from User where userName='User With Where'"); //select * from User(class name) entity where userName(field name) = ?
		
		List users = hibernateQuery.list();
		List usersWithWhere = hibernateQueryWithWhere.list();
		
		
		//parameterised queries - to prevent SQL injection attacks
		Query hibernateQueryWithParams = session.createQuery("from User where userId > ?1 and userName = ?2"); //select * from User(class name) entity where userName(field name) = ?
		hibernateQueryWithParams.setParameter(1, 0);
		hibernateQueryWithParams.setParameter(2, "User With Where");
		List usersWithParams = hibernateQueryWithParams.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("No of users = " + users.size());
		System.out.println("where clause result = " + usersWithWhere.size());
		System.out.println("parametrized result = " + usersWithParams.size());
	}
}
