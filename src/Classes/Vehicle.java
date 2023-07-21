package Classes;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import Enums.Maintenance;
import Enums.TypeOfVehicle;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean isWorking;
	private long capacity;
	private TypeOfVehicle tov;
	private int daysOnDuty;
	private Maintenance daysOutOfService;
	@ManyToOne
	private Route route;
	private int completedRoutes;
		
	public Vehicle() {
		super();
	}
	
	public Vehicle(TypeOfVehicle tov, long capacity) {
		super();
		this.isWorking = true;
		this.tov = tov;
		this.capacity = capacity;
		this.completedRoutes = 0;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean getIsWorking() {
		return isWorking;
	}
	
	public void setIsWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	
	public long getCapacity() {
		return capacity;
	}
	
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	
	public TypeOfVehicle getTov() {
		return tov;
	}

	public void setTov(TypeOfVehicle tov) {
		this.tov = tov;
	}

	public int getDaysOnDuty() {
		return daysOnDuty;
	}
	
	public void setDaysOnDuty(int daysOnDuty) {
		this.daysOnDuty = daysOnDuty;
	}
	
	public Maintenance getDaysOutOfService() {
		return daysOutOfService;
	}

	public void setDaysOutOfService(Maintenance daysOutOfService) {
		this.daysOutOfService = daysOutOfService;
	}
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	public int getCompletedRoutes() {
		return completedRoutes;
	}

	public void setCompletedRoutes(int completedRoutes) {
		this.completedRoutes = completedRoutes;
	}

	public void sendToMaintenance(int n) {
		if(daysOutOfService != null) {
			this.isWorking = false;
		}else {
			this.isWorking = true;
			this.daysOnDuty = daysOnDuty + n;
		}
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", isWorking=" + isWorking + ", capacity=" + capacity + ", daysOnDuty="
				+ daysOnDuty + ", daysOutOfService=" + daysOutOfService + "]";
	}

}
