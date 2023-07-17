package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import Abstract.TicketSeller;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private TicketSeller seller;
	
	public Ticket() {
		super();
	}

	public Ticket(TicketSeller seller) {
		super();
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TicketSeller getSeller() {
		return seller;
	}

	public void setSeller(TicketSeller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", seller=" + seller + "]";
	}

}
