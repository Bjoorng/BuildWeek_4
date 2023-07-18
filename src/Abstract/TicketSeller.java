package Abstract;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class TicketSeller {
	
	@Id
	@SequenceGenerator(name = "elCat_seq", sequenceName = "elCat_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elCat_seq")
	private Long id;
	@Column(name = "seller_name")
	private String name;
	
	public TicketSeller() {
		super();
	}

	public TicketSeller(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TicketSeller [id=" + id + ", name=" + name + "]";
	}

}
