package Classes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
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
	@OneToOne(cascade = CascadeType.ALL)
	private Person person;
	private LocalDate emissionDate;
	private LocalDate expirationDate;
	private boolean isValid;
	
	public Card() {
		super();
	}

	public Card(LocalDate emissionDate) {
		super();
		this.emissionDate = emissionDate;
		this.expirationDate = emissionDate.plusYears(1);
		this.isValid = true;
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

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "Card [id=" + getId() + "]";
	}
	
	public boolean checkValidity() {
		if(LocalDate.now().isAfter(emissionDate) && LocalDate.now().isBefore(expirationDate)) {
			isValid = true;
		}else {
			isValid = false;
		}
		return isValid;
	}
}
