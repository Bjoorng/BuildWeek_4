package ClassesDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Abstract.TicketSeller;
import Abstract.Travel;
import Classes.VendingMachine;
import Classes.Pass;
import Classes.Person;
import Classes.Shop;
import Classes.Ticket;
import Utils.JpaUtils;

public class SellerDAO extends JpaUtils {

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();

	public void saveShop(Shop s) throws SQLException {
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.refresh(s);
		System.out.println(s);
	}

	public void saveVending(VendingMachine v) throws SQLException {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.refresh(v);
		System.out.println(v);
	}

	public void deleteShop(long id) throws SQLException {
		em.getTransaction().begin();
		Shop s = em.find(Shop.class, id);
		em.remove(s);
		em.getTransaction().commit();
		System.out.println("Card:" + s.getId() + "Of: " + s.getName() + " deleted");
	}

	public void deleteVending(long id) throws SQLException {
		em.getTransaction().begin();
		VendingMachine v = em.find(VendingMachine.class, id);
		em.remove(v);
		em.getTransaction().commit();
		System.out.println("Card:" + v.getId() + "Of: " + v.getName() + " deleted");
	}

	public void sellTicket(Ticket ticket, TicketSeller seller, Person p) throws SQLException {
		em.getTransaction().begin();
		Person managedPerson = em.merge(p);
		ticket.setPerson(managedPerson);
		em.persist(ticket);
		em.merge(seller);
		em.getTransaction().commit();
		System.out.println("Ticket sold successfully!");
	}

	public void sellPass(Pass pass, TicketSeller seller, Person person) {
		em.getTransaction().begin();
		if (person.getCardNum().getId() != null && person.getCardNum().checkValidity()) {
			Person managedPerson = em.merge(person);
			pass.setPerson(managedPerson);
			em.persist(pass);
			em.merge(seller);
			em.getTransaction().commit();
			System.out.println("Pass sold successfully!");
		} else {
			Person managedPerson = em.merge(person);
			pass.setPerson(managedPerson);
			em.getTransaction().commit();
			System.out.println("Failed To Sell The Pass");
		}
	}

	public void inMaintenance(long id) throws SQLException {
		em.getTransaction().begin();
		VendingMachine managedVendingMachine = em.find(VendingMachine.class, id);
		if (managedVendingMachine != null) {
			if (managedVendingMachine.getIsWorking()) {
				managedVendingMachine.setIsWorking(false);
				System.out.println("Card: " + managedVendingMachine.getId() + " Of: " + managedVendingMachine.getName()
						+ " is in maintenance");
			} else {
				managedVendingMachine.setIsWorking(true);
				System.out.println("Card: " + managedVendingMachine.getId() + " Of: " + managedVendingMachine.getName()
						+ " is out of maintenance");
			}
			em.getTransaction().commit();
		} else {
			System.out.println("VendingMachine entity not found");
		}
	}

	public List<Travel> searchByDate(String v, LocalDate start, LocalDate end) {
		em.getTransaction().begin();
		TypedQuery<Travel> query = em.createQuery(
				"SELECT t FROM Travel t WHERE t.seller.name LIKE :vendorName AND t.soldIn BETWEEN :startDate AND :endDate",
				Travel.class);
		query.setParameter("vendorName", v);
		query.setParameter("startDate", start);
		query.setParameter("endDate", end);
		List<Travel> tickets = query.getResultList();
		em.getTransaction().commit();
		for (Travel ticket : tickets) {
			System.out.println(ticket);
		}
		return tickets;
	}
}
