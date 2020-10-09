package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.jpa.HibernatePersistenceProvider;

//package and import statements
@Entity
@Table(name="traveler")
public class Traveler {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRAVELER_ID")
	private int id;
	@Column(name="TRAVELER_NAME")
	private String travelerName;
	
	public Traveler () {
		super();
	}
	
	public Traveler(int id, String travelerName) {
		super();
		this.id = id;
		this.travelerName = travelerName;
	}
	
	public Traveler(String travelerName) {
		super();
		this.travelerName = travelerName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTravelerName() {
		return travelerName;
	}
	public void setTravelerName(String travelerName) {
		this.travelerName = travelerName;
	}
	@Override
	public String toString() {
		return "Traveler [id=" + id + " , travelerName=" + travelerName + "]";
	}

}
