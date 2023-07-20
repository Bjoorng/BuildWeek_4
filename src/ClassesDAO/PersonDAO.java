package ClassesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Classes.Person;
import Utils.JpaUtils;

public class PersonDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();

	public Person savePerson(Person p) throws SQLException {
	    em.getTransaction().begin();
	    em.merge(p);
	    em.getTransaction().commit();
	    System.out.println(p);
		return p;
	}
	
	public Person getById(long id) throws SQLException {
		em.getTransaction().begin();
		Person p = em.find(Person.class, id);
		em.getTransaction().commit();
		return p;
	}
	
	public void deletePerson(long id) throws SQLException {
		em.getTransaction().begin();
		Person p = em.find(Person.class, id);
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Card:" + p.getId() + "Of: " + p.getFirstName() + " " + p.getLastName() + " deleted");
	}
}
