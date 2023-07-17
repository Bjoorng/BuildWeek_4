package Abstract;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Travel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate soldIn;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private TicketSeller seller;
	
	public Travel() {
		super();
	}

	public Travel(LocalDate soldIn, TicketSeller seller) {
		super();
		this.soldIn = soldIn;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getSoldIn() {
		return soldIn;
	}

	public void setSoldIn(LocalDate soldIn) {
		this.soldIn = soldIn;
	}

	public TicketSeller getSeller() {
		return seller;
	}

	public void setSeller(TicketSeller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Travel [id=" + id + ", soldIn=" + soldIn + ", seller=" + seller + "]";
	}

}
