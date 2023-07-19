package Classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import Abstract.Travel;
import Enums.Validity;

@Entity
public class Pass extends Travel{
	
	@Enumerated
	private Validity validity;
	@OneToOne
	private Card card;
	
	public Pass() {
		super();
	}

	public Pass(LocalDate soldIn, Validity validity, Card card) {
		super(soldIn);
		this.validity = validity;
		this.card = card;
	}

	public Validity getValidity() {
		return validity;
	}

	public void setValidity(Validity validity) {
		this.validity = validity;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Pass [validity=" + validity + ", soldBy=" + getSeller() + "]";
	}

	
}
