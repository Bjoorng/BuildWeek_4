package ClassesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Classes.Card;
import Utils.JpaUtils;

public class CardDAO extends JpaUtils{

		public EntityManagerFactory emf = getEntityManagerFactory();
		public EntityManager em = emf.createEntityManager();

		public void saveCard(Card c) throws SQLException {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.refresh(c);
			System.out.println(c);
		}
		
}
