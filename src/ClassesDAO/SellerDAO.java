package ClassesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Classes.VendingMachine;
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
	
}
