package it.uniroma3.project.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class UseRequest {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private LocalDate date;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private String email;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Photograph> photograph;

	
	public UseRequest() {}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Photograph> getPhotograph() {
		return photograph;
	}

	public void setPhotograph(List<Photograph> photograph) {
		this.photograph = photograph;
	}
	
	public void addPhotograph(Photograph  photo) {
		this.photograph.add(photo);
	}
	
	public void setData(String name, String surname, String email) {
		this.name=name;
		this.surname = surname;
		this.email= email;
	}
	
	public Long getTotal() {
		long total = 0;
		
		for(Photograph ph: this.photograph) {
			total = total + ph.getPrice();
		}
		
		return total;
	}
	
	
	
	
	
	
	

}
