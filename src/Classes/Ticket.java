package Classes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import Abstract.TicketSeller;
import Abstract.Travel;

@Entity
public class Ticket extends Travel{
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Person person;
	
	public Ticket() {
		super();
	}
	
	public Ticket(LocalDate soldIn, TicketSeller seller, Person person) {
		super(soldIn, seller);
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}
