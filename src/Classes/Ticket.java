package Classes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import Abstract.Travel;

@Entity
public class Ticket extends Travel{
	
	private LocalDate stampedIn;
	@ManyToOne(cascade = CascadeType.ALL)
	private Vehicle vehicle;
	
	public Ticket() {
		super();
	}
	
	public Ticket(LocalDate soldIn) {
		super(soldIn);
	}

	public LocalDate getStampedIn() {
		return stampedIn;
	}

	public void setStampedIn(LocalDate stampedIn) {
		this.stampedIn = stampedIn;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Ticket [stampedIn=" + stampedIn + ", getId()=" + getId() + ", getSoldIn()=" + getSoldIn()
				+ ", getSeller()=" + getSeller() + "]";
	}
	
}
