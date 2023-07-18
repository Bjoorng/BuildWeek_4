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

	    if (em.contains(t)) {
	        // Entity is already managed, no need for persistence operation
	        System.out.println("Ticket already present in the database: " + t);
	    } else {
	        // Entity is detached, use merge to handle both detached and new entities
	        Ticket mergedTicket = em.merge(t);
	        em.getTransaction().commit();
	        em.refresh(mergedTicket);
	        System.out.println(mergedTicket);
	    }
	}
	
	public void savePass(Pass p) throws SQLException {
		em.getTransaction().begin();

	    if (em.contains(p)) {
	        // Entity is already managed, no need for persistence operation
	        System.out.println("Ticket already present in the database: " + p);
	    } else {
	        // Entity is detached, use merge to handle both detached and new entities
	        Pass mergedPass = em.merge(p);
	        em.getTransaction().commit();
	        em.refresh(mergedPass);
	        System.out.println(mergedPass);
	    }
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
		System.out.println("Pass:" + p.getId() + "Of: " + p.getCard().getPerson() + " deleted");
	}
}
