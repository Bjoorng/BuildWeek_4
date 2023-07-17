package Classes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import Abstract.TicketSeller;

@Entity
@DiscriminatorValue("vending_machine")
public class VendingMachine extends TicketSeller {

	private boolean isWorking;

	public VendingMachine() {
		super();
    }

	public VendingMachine(String name, boolean isWorking) {
        super(name);
        this.isWorking = isWorking;
    }

    public boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    @Override
    public String toString() {
        return "VendingMachine [isWorking=" + isWorking + ", id=" + getId() + ", name=" + getName() + "]";
    }

}
