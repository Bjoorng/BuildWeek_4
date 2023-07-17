package MainClass;

import java.sql.SQLException;
import java.time.LocalDate;

import Abstract.TicketSeller;
import Classes.*;
import ClassesDAO.CardDAO;
import ClassesDAO.PersonDAO;
import ClassesDAO.SellerDAO;
import ClassesDAO.TicketDAO;
import Enums.Validity;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		
		Person p1 = new Person("Francesca", "Neri", LocalDate.of(1977, 3, 22));
		Card c1 = new Card(LocalDate.of(2023, 02, 12), LocalDate.of(2024, 02, 12), p1);
		Shop s1 = new Shop("Tabacchino DiGregorio");
		
		TicketSeller v1 = new VendingMachine("Vending DiGregorio", true);
		Ticket t1 = new Ticket(LocalDate.of(2023, 5, 22), v1, p1);
		Pass pas1 = new Pass(LocalDate.of(2023, 5, 22), v1, Validity.MONTHLY, p1);
		
		
		
		CardDAO cDao = new CardDAO();
		PersonDAO pDao = new PersonDAO();
		SellerDAO sDao = new SellerDAO();
		TicketDAO tDao = new TicketDAO();
		cDao.saveCard(c1);
		p1.setCardNum(c1);
		//pDao.savePerson(p1);
		//sDao.saveVending(v1);
		//tDao.saveTicket(t1);
		//sDao.searchByDate(v1.getName(), LocalDate.of(2023, 5, 30), LocalDate.of(2023, 5, 31));
		//sDao.sellTicket(t1, v1, p1);
		sDao.sellPass(pas1, v1, p1);
	}

}
