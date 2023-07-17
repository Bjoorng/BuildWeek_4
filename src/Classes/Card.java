package Classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "cardNum")
	private Person person;
	private LocalDate emissionDate;
	private LocalDate expirationDate;
	
	public Card() {
		super();
	}

	public Card(LocalDate emissionDate, LocalDate expirationDate) {
		super();
		this.emissionDate = emissionDate;
		this.expirationDate = expirationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getEmissionDate() {
		return emissionDate;
	}

	public void setEmissionDate(LocalDate emissionDate) {
		this.emissionDate = emissionDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", person=" + person + ", emissionDate=" + emissionDate + ", expirationDate="
				+ expirationDate + "]";
	}
	
}
