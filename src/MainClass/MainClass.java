package MainClass;

import java.sql.SQLException;
import java.time.LocalDate;

import Classes.*;
import ClassesDAO.CardDAO;
import ClassesDAO.PersonDAO;
import ClassesDAO.RouteDAO;
import ClassesDAO.SellerDAO;
import ClassesDAO.TicketDAO;
import ClassesDAO.VehicleDAO;
import Enums.TypeOfVehicle;
import Enums.Validity;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		
		Person p1 = new Person("Francesca", "Neri", LocalDate.of(1977, 3, 22));
		Card c1 = new Card(LocalDate.of(2023, 02, 12), LocalDate.of(2024, 02, 12));
		Shop s1 = new Shop("Tabacchino DiGregorio");
		
		VendingMachine v1 = new VendingMachine("Vending DiGregorio", true);
		Ticket t1 = new Ticket(LocalDate.of(2023, 5, 22));
		Pass pas1 = new Pass(LocalDate.of(2023, 5, 22), Validity.MONTHLY, c1);
		Vehicle ve1 = new Vehicle(TypeOfVehicle.BUS, 60);
		Vehicle ve2 = new Vehicle(TypeOfVehicle.TRAM, 120);
		Route r1 = new Route("Stazione Centrale", "Concerto T.Swift", 32.5);
		
		
		CardDAO cDao = new CardDAO();
		PersonDAO pDao = new PersonDAO();
		SellerDAO sDao = new SellerDAO();
		TicketDAO tDao = new TicketDAO();
		VehicleDAO veDao = new VehicleDAO();
		RouteDAO rDao = new RouteDAO();
		c1.setPerson(p1);
		cDao.saveCard(c1);
		pDao.savePerson(p1);
		p1.setCardNum(c1);
		VendingMachine vending = sDao.saveVending(v1);
		Ticket t = tDao.saveTicket(t1);
		Pass p = tDao.savePass(pas1);
		sDao.searchByDate(vending.getName(), LocalDate.of(2023, 5, 30), LocalDate.of(2023, 5, 31));
		sDao.sellTicket(t, vending);
		sDao.sellPass(p, c1);
		Vehicle vehicle = veDao.saveVehicle(ve1);
		Route r = rDao.saveRoute(r1);
		System.out.println(t.getId());
		veDao.stampTicket(vehicle, t, LocalDate.now());
		veDao.searchByDate(LocalDate.of(2023, 2, 12), LocalDate.of(2023, 8, 22));
		veDao.assignRoute(vehicle, r);
	}

}
