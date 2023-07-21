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
		
		
		Card c1 = new Card(LocalDate.of(2023, 02, 12));
		Card c2 = new Card(LocalDate.of(2023, 8, 22));
        Card c3 = new Card(LocalDate.of(2023, 3, 18));
        Card c4 = new Card(LocalDate.of(2023, 11, 9));
        Person p1 = new Person("Francesca", "Neri", LocalDate.of(1977, 3, 22));
		Person p2 = new Person("Mario", "Rossi", LocalDate.of(1987, 6, 15));
        Person p3 = new Person("Giuseppe", "Verdi", LocalDate.of(1999, 12, 8));
        Person p4 = new Person("Sara", "Rosa", LocalDate.of(1995, 9, 30));
        
		c1.setPerson(p1);
		c2.setPerson(p2);
		c3.setPerson(p3);
		c4.setPerson(p4);
		p1.setCardNum(c1);
		p2.setCardNum(c2);
		p3.setCardNum(c3);
		p4.setCardNum(c4);
        
		Shop s1 = new Shop("Tabacchino DiGregorio");
		Shop s2 = new Shop("Tabacchino");
		VendingMachine v1 = new VendingMachine("Vending DiGregorio", true);
		VendingMachine v2 = new VendingMachine("Ticket Machine", false);
		
		Ticket t1 = new Ticket(LocalDate.of(2023, 5, 22));
		Ticket t2 = new Ticket(LocalDate.of(2023, 3, 15));
        Ticket t3 = new Ticket(LocalDate.of(2022, 10, 27));
        Ticket t4 = new Ticket(LocalDate.of(2023, 1, 7));
		Pass pas1 = new Pass(LocalDate.of(2023, 5, 22), Validity.MONTHLY, c1);
		Pass pas2 = new Pass(LocalDate.of(2023, 2, 13), Validity.WEEKLY, c2);
        Pass pas3 = new Pass(LocalDate.of(2023, 6, 27), Validity.WEEKLY, c3);
        Pass pas4 = new Pass(LocalDate.of(2023, 3, 10), Validity.MONTHLY, c4);
		
		Vehicle ve1 = new Vehicle(TypeOfVehicle.BUS, 60);
		Vehicle ve2 = new Vehicle(TypeOfVehicle.TRAM, 120);
		Vehicle ve3 = new Vehicle(TypeOfVehicle.TRAM, 120);
        Vehicle ve4 = new Vehicle(TypeOfVehicle.BUS, 60);
        Route r1 = new Route("Stazione Centrale", "Concerto T.Swift", 50);
		Route r2 = new Route("Stazione Centrale", "Centro", 43);
        Route r3 = new Route("Centro Storico", "Lido", 45);
		
		CardDAO cDao = new CardDAO();
		PersonDAO pDao = new PersonDAO();
		SellerDAO sDao = new SellerDAO();
		TicketDAO tDao = new TicketDAO();
		VehicleDAO veDao = new VehicleDAO();
		RouteDAO rDao = new RouteDAO();
		
		Card card = cDao.saveCard(c1);
		Card card2 = cDao.saveCard(c2);
		Card card3 = cDao.saveCard(c3);
		Card card4 = cDao.saveCard(c4);
		
		Person person = pDao.savePerson(p1);
		Person person2 = pDao.savePerson(p2);
		Person person3 = pDao.savePerson(p3);
		Person person4 = pDao.savePerson(p4);
		
		VendingMachine vending = sDao.saveVending(v1);
		VendingMachine vending2 = sDao.saveVending(v2);
		Shop shop = sDao.saveShop(s1);
		Shop shop2 = sDao.saveShop(s2);
		
		Ticket ticket = tDao.saveTicket(t1);
		Ticket ticket2 = tDao.saveTicket(t2);
		Ticket ticket3 = tDao.saveTicket(t3);
		Ticket ticket4 = tDao.saveTicket(t4);
		Pass pass = tDao.savePass(pas1);
		Pass pass2 = tDao.savePass(pas2);
		Pass pass3 = tDao.savePass(pas3);
		Pass pass4 = tDao.savePass(pas4);
		
		sDao.sellTicket(ticket, vending);
		sDao.sellTicket(ticket2, vending);
		sDao.sellTicket(ticket3, vending);
		sDao.sellTicket(ticket4, vending);
		sDao.sellPass(pass, card, shop);
		sDao.sellPass(pass2, card2, shop);
		sDao.sellPass(pass3, card3, shop2);
		sDao.sellPass(pass4, card4, shop2);
		sDao.searchByDate(vending.getName(), LocalDate.of(2023, 5, 30), LocalDate.of(2023, 5, 31));

		
		Vehicle vehicle = veDao.saveVehicle(ve1);
		Vehicle vehicle2 = veDao.saveVehicle(ve2);
		Vehicle vehicle3 = veDao.saveVehicle(ve3);
		Vehicle vehicle4 = veDao.saveVehicle(ve4);
		Route route = rDao.saveRoute(r1);
		Route route2 = rDao.saveRoute(r2);
		Route route3 = rDao.saveRoute(r3);
		
		veDao.stampTicket(vehicle, ticket, LocalDate.now());
		veDao.stampTicket(vehicle3, ticket2, LocalDate.now());
		veDao.stampTicket(vehicle2, ticket3, LocalDate.now());
		veDao.searchByDate(LocalDate.of(2023, 2, 12), LocalDate.of(2023, 8, 22));
		veDao.assignRoute(vehicle, route);
		veDao.assignRoute(vehicle2, route2);
		veDao.assignRoute(vehicle3, route3);
		veDao.assignRoute(vehicle4, route);
		veDao.completeRoute(vehicle);
		veDao.completeRoute(vehicle);
		veDao.completeRoute(vehicle);
		veDao.completeRoute(vehicle);
		veDao.completeRoute(vehicle);
	}

}
