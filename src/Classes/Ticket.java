package Classes;

import java.time.LocalDate;

import javax.persistence.Entity;

import Abstract.TicketSeller;
import Abstract.Travel;

@Entity
public class Ticket extends Travel{
	
	public Ticket() {
		super();
	}
	
	public Ticket(LocalDate soldIn, TicketSeller seller) {
		super(soldIn, seller);
	}

}
