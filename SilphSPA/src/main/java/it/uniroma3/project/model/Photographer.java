package it.uniroma3.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * @author Reko
 *
 */
@Entity
public class Photographer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column 
	private String surname;
	
	@Column
	private String email;
	

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private byte[] profileImg;
	
	@OneToMany(mappedBy="photographer", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Album> album;
	
	
	
	
	public byte[] getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(byte[] profileImg) {
		this.profileImg = profileImg;
	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}

	public Photographer(String name, String surname, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.album = new ArrayList<Album>();
	}
	
	public Photographer() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	

}
