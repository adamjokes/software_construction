package springbootvisitormanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visitors")
public class Visitor {

	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String temperature;
	private String DOB;
	
	public Visitor() {
		
	}
	
	public Visitor(String firstName, String lastName, String emailId, String temperature, String DOB) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.temperature = temperature;
		this.DOB = DOB;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "temperature", nullable = false)
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@Column(name = "DOB", nullable = false)
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", temperature=" + temperature + ", DOB=" + DOB 
				+ "]";
	}
	
}
