package ClassesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Classes.Vehicle;
import Utils.JpaUtils;

public class VehicleDAO extends JpaUtils{

	public EntityManagerFactory emf = getEntityManagerFactory();
	public EntityManager em = emf.createEntityManager();
	
	public void saveVehicle(Vehicle v) throws SQLException {
	    em.getTransaction().begin();
	    Vehicle managedVehicle = em.merge(v);
	    em.getTransaction().commit();
	    em.refresh(managedVehicle);
	    System.out.println(managedVehicle);
	}
	
	public Vehicle getById(long id) throws SQLException {
		em.getTransaction().begin();
		Vehicle v = em.find(Vehicle.class, id);
		em.getTransaction().commit();
		if(v.getIsWorking()) {
			System.out.println("Vehicle:" + v.getId() + " Is Working");
		}else {
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
}
