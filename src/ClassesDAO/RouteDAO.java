package ClassesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Classes.Route;
import Utils.JpaUtils;

public class RouteDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();

	public Route saveRoute(Route r) throws SQLException {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		return r;
	}
	
	public Route deleteRoute(Route r) throws SQLException {
		em.getTransaction().begin();
		em.remove(r);
		em.getTransaction().commit();
		return r;
	}
}
