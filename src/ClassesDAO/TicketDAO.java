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

	public void saveTicket(Ticket t) throws SQLException {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.refresh(t);
		System.out.println(t);
	}
	
	public void savePass(Pass p) throws SQLException {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.refresh(p);
		System.out.println(p);
	}
	
	public void deleteTicket(long id) throws SQLException {
		em.getTransaction().begin();
		Ticket t = em.find(Ticket.class, id);
		em.remove(t);
		em.getTransaction().commit();
		System.out.println("Ticket:" + t.getId() + " deleted");
	}
	
	public void deletePass(long id) throws SQLException {
		em.getTransaction().begin();
		Pass p = em.find(Pass.class, id);
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Pass:" + p.getId() + "Of: " + p.getPerson() + " deleted");
	}
}
