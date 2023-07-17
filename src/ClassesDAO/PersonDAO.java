package ClassesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Classes.Person;
import Utils.JpaUtils;

public class PersonDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();

	public void savePerson(Person p) throws SQLException {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.refresh(p);
		System.out.println(p);
	}
	
	
}
