package MainClass;

import java.sql.SQLException;
import java.time.LocalDate;

import Classes.*;
import ClassesDAO.CardDAO;
import ClassesDAO.PersonDAO;
import ClassesDAO.SellerDAO;
import ClassesDAO.TicketDAO;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		
		Card c1 = new Card(LocalDate.of(2023, 02, 12), LocalDate.of(2024, 02, 12));
		Person p1 = new Person("Francesca", "Neri", LocalDate.of(1977, 3, 22));
		Shop s1 = new Shop("Tabacchino DiGregorio");
		VendingMachine v1 = new VendingMachine("Vending DiGregorio", true);
		Ticket t1 = new Ticket(v1);
		
		
		CardDAO cDao = new CardDAO();
		PersonDAO pDao = new PersonDAO();
		SellerDAO sDao = new SellerDAO();
		TicketDAO tDao = new TicketDAO();
		//cDao.saveCard(c1);
		//pDao.savePerson(p1);
		//cDao.deleteCard(4);
		//pDao.deletePerson(6);
		//sDao.inMaintenance(2);
		tDao.saveTicket(t1);
		
	}

}
