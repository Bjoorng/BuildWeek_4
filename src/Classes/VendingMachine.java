package Classes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Abstract.TicketSeller;

@Entity
@DiscriminatorValue("vending_machine")
public class VendingMachine extends TicketSeller{
	
	private boolean isWorking;

	public VendingMachine(String name) {
		super(name);
	}

	public VendingMachine(String name, boolean isWorking) {
		super(name);
		this.isWorking = isWorking;
	}

	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

	@Override
	public String toString() {
		return "VendingMachine [isWorking=" + isWorking + "]";
	}

}
