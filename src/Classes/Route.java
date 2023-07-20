package Classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String startingPoint;
	private String endingPoint;
	long avgTime;
	
	public Route() {
		super();
	}
	public Route(String startingPoint, String endingPoint, long avgTime) {
		super();
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.avgTime = avgTime;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStartingPoint() {
		return startingPoint;
	}
	
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	
	public String getEndingPoint() {
		return endingPoint;
	}
	
	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}
	
	public double getAvgTime() {
		return avgTime;
	}
	
	public void setAvgTime(long avgTime) {
		this.avgTime = avgTime;
	}
	
	@Override
	public String toString() {
		return "Route [id=" + id + ", startingPoint=" + startingPoint + ", endingPoint=" + endingPoint + ", avgTime="
				+ avgTime + "]";
	}
	
}
