package ClassesDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import Abstract.Travel;
import Classes.Route;
import Classes.Ticket;
import Classes.Vehicle;
import Utils.JpaUtils;

public class VehicleDAO extends JpaUtils {

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();

	public Vehicle saveVehicle(Vehicle v) throws SQLException {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		System.out.println(v);
		return v;
	}

	public Vehicle getById(long id) throws SQLException {
		em.getTransaction().begin();
		Vehicle v = em.find(Vehicle.class, id);
		em.getTransaction().commit();
		if (v.getIsWorking()) {
			System.out.println("Vehicle:" + v.getId() + " Is Working");
		} else {
			System.out.println("Vehicle:" + v.getId() + " Is In Maintenance");
		}
		return v;
	}

	public void deleteVehicle(long id) throws SQLException {
		em.getTransaction().begin();
		Vehicle v = em.find(Vehicle.class, id);
		em.remove(v);
		em.getTransaction().commit();
		System.out.println("Vehicle:" + v.getId() + " deleted");
	}

	public void stampTicket(Vehicle v, Ticket t, LocalDate d) {
		em.getTransaction().begin();
		t.setStampedIn(d);
		t.setVehicle(v);
		em.merge(t);
		em.getTransaction().commit();
		System.out.println("Tickets Stamped Vehicle");
	}

	public List<Travel> searchByDate(LocalDate start, LocalDate end) {
		em.getTransaction().begin();
		TypedQuery<Travel> query = em
				.createQuery("SELECT t FROM Travel t WHERE t.stampedIn BETWEEN :startDate AND :endDate", Travel.class);
		query.setParameter("startDate", start);
		query.setParameter("endDate", end);
		List<Travel> tickets = query.getResultList();
		em.getTransaction().commit();
		for (Travel ticket : tickets) {
			System.out.println(ticket);
		}
		return tickets;
	}
	
	public void assignRoute(Vehicle v, Route r) {
		em.getTransaction().begin();
		v.setRoute(r);
		em.merge(v);
		em.getTransaction().commit();
		System.out.println(v + "route" + r);
	}

	public void completeRoute(Vehicle v) {
		em.getTransaction().begin();
		v.setCompletedRoutes(v.getCompletedRoutes() + 1);
		em.merge(v);
		em.getTransaction().commit();
		System.out.println("this vehicle has completed" + " " + v.getCompletedRoutes() + " " + "routes");
	}
}
