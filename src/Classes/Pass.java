package Classes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import Abstract.TicketSeller;
import Enums.Validity;

@Entity
public class Pass extends Ticket{
	
	private Validity validity;
	@OneToOne
	private Person person;
	@ManyToOne
	private TicketSeller sellers;
	
	public Pass() {
		super();
	}

	public Pass(Validity validity, Person person, TicketSeller sellers) {
		super();
		this.validity = validity;
		this.person = person;
		this.sellers = sellers;
	}

	public Validity getValidity() {
		return validity;
	}

	public void setValidity(Validity validity) {
		this.validity = validity;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public TicketSeller getSeller() {
		return sellers;
	}

	public void setSeller(TicketSeller seller) {
		this.sellers = seller;
	}

	@Override
	public String toString() {
		return "Pass [validity=" + validity + ", person=" + person + ", seller=" + sellers + "]";
	}

}
