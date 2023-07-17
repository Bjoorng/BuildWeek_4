package Classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import Abstract.TicketSeller;
import Abstract.Travel;
import Enums.Validity;

@Entity
public class Pass extends Travel{
	
	private Validity validity;
	@OneToOne
	private Person person;
	
	public Pass() {
		super();
	}

	public Pass(LocalDate soldIn, TicketSeller seller, Validity validity, Person person) {
		super(soldIn, seller);
		this.validity = validity;
		this.person = person;
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

	@Override
	public String toString() {
		return "Pass [validity=" + validity + ", person=" + person + ", soldBy=" + getSeller() + "]";
	}

	
}
