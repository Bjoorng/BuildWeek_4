package ClassesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Classes.Ticket;
import Classes.Pass;
import Utils.JpaUtils;

public class TicketDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();

	public Ticket saveTicket(Ticket t) throws SQLException {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		return t;
	}
	
	public Pass savePass(Pass p) throws SQLException {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		return p;
	}
	
	public void deleteTicket(Ticket t) throws SQLException {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
		System.out.println("Ticket:" + t.getId() + " deleted");
	}
	
	public void deletePass(Pass p) throws SQLException {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Pass:" + p.getId() + "Of: " + p.getCard().getPerson() + " deleted");
	}
}
