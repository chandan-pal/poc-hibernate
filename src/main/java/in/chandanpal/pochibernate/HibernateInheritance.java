package in.chandanpal.pochibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.chandanpal.pochibernate.model.FourWheeler;
import in.chandanpal.pochibernate.model.TwoWheeler;
import in.chandanpal.pochibernate.model.Vehicle;

public class HibernateInheritance {
	
	static void runHiberNateInheritance() {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("General Vehicle");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setSteeringHandle("bike steering handle");
		bike.setVehicleName("bike");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("car");
		car.setSteeringWheel("car steering wheel");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		session.getTransaction().commit();
		session.close();
				
		
	}

}