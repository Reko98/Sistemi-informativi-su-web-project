package it.uniroma3.project.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String albumName;
	
	@Column
	private LocalDate publicationYear;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Photographer photographer;
	
	@JoinColumn(name = "album")
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Photograph> photograph;
	
	
	
	
	public Album(String albumName, LocalDate publicationYear, Photographer photographer) {
		super();
		this.albumName = albumName;
		this.publicationYear = publicationYear;
		this.photographer = photographer;
		this.photograph = new ArrayList<>();
	}
	
	public Album() {}
	
	
	public void addPhotograph(String name, Long price) {
		this.photograph.add(new Photograph(name,price,this.photographer));
	}

	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

	public List<Photograph> getPhotograph() {
		return photograph;
	}

	public void setPhotograph(List<Photograph> photograph) {
		this.photograph = photograph;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public LocalDate getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(LocalDate publicationYear) {
		this.publicationYear = publicationYear;
	}
	
			
}
