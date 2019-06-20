package it.uniroma3.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Photograph {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String photoName;
	
	@Column
	private Long price;
	
	
	
	@ManyToOne
	private Photographer photographer;
	
	@Lob
	@Column(nullable=false)
	private byte[] imageSrc;

	
	
	
	
	public Photograph(String photoName, Long price, Photographer photographer) {
		super();
		this.photoName = photoName;
		this.price = price;
		this.photographer = photographer;
	}
	
	public Photograph() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

	public byte[] getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(byte[] imageSrc) {
		this.imageSrc = imageSrc;
	}
	
	
	
	
	
		
}
