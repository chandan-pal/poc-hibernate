package in.chandanpal.pochibernate;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocHibernateApplication.class, args);
		
		//HibernateBasics.runHiberNateBasics();
		
		HibernateInheritance.runHiberNateInheritance();
	}

}
