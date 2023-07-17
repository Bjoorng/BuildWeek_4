package Classes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Abstract.TicketSeller;

@Entity
@DiscriminatorValue("shop")
public class Shop extends TicketSeller{

	public Shop() {
		super();
	}
	
	public Shop(String name) {
		super(name);
	}
	
}
