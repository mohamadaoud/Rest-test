package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patients {
	
	@Id
	@GeneratedValue
	public int id;
	public String name;
	public String address;

}
