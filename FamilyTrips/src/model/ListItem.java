package model;

//Luke Xiong

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ListItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="YEAR")
	private String year;
	@Column(name="LOCATION")
	private String location;
	
	public ListItem() {
		super();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public	ListItem(String year,	String	location){
		super();
		this.year	=	year;
		this.location	=	location;
		}
	
	public	String	returnItemDetails(	)	{
		return	year	+	":	"	+	location;
		}
	
}


