package Classes;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import Abstract.TicketSeller;

@Entity
@DiscriminatorValue("shop")
public class Shop extends TicketSeller{

	@OneToMany
	private List<Ticket> tickets;
	@OneToMany
	private List<Pass> passes;
	@OneToMany
	private List<Person> people;
	
	public Shop() {
		super();
	}
	
	public Shop(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Shop [getId()=" + getId() + ", getName()=" + getName() + "]";
	}
		
}
