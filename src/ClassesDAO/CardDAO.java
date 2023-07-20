package ClassesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Classes.Card;
import Classes.Person;
import Utils.JpaUtils;

public class CardDAO extends JpaUtils{

		public EntityManagerFactory emf = getEntityManagerFactory();
		public EntityManager em = emf.createEntityManager();

		public Card saveCard(Card c) throws SQLException {
			em.getTransaction().begin();
		    Person person = c.getPerson();
		    if (person != null) {
		        if (person.getId() == null) {
		            em.persist(person);
		        } else {
		            person = em.merge(person);
		        }
		        c.setPerson(person);
		        person.setCardNum(c);
		    }
		    em.persist(c);
		    em.getTransaction().commit();
		    em.refresh(c);
		    System.out.println(c);
			return c;
		}
		
		public void deleteCard(long id) throws SQLException {
			em.getTransaction().begin();
			Card c = em.find(Card.class, id);
			em.remove(c);
			em.getTransaction().commit();
			System.out.println("Card:" + c.getId() + "Of: " + c.getPerson() + " deleted");
		}
}
