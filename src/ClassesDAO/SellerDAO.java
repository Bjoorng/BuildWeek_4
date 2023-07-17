package ClassesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Classes.VendingMachine;
import Classes.Person;
import Classes.Shop;
import Utils.JpaUtils;

public class SellerDAO extends JpaUtils{

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
	
	public void sellTicket() {
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
	
	public void sellPass() {
		em.getTransaction().begin();
		em.getTransaction().commit();
	}
	
	public void inMaintenance(long id) throws SQLException {
	    em.getTransaction().begin();
	    VendingMachine managedVendingMachine = em.find(VendingMachine.class, id);
	    if (managedVendingMachine != null) {
	        if (managedVendingMachine.getIsWorking()) {
	            managedVendingMachine.setIsWorking(false);
	            System.out.println("Card: " + managedVendingMachine.getId() + " Of: " + managedVendingMachine.getName() + " is in maintenance");
	        } else {
	            managedVendingMachine.setIsWorking(true);
	            System.out.println("Card: " + managedVendingMachine.getId() + " Of: " + managedVendingMachine.getName() + " is out of maintenance");
	        }
	        em.getTransaction().commit();
	    } else {
	        System.out.println("VendingMachine entity not found");
	    }
	}
}
