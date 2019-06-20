package it.uniroma3.project.service;
import it.uniroma3.project.model.Photographer;
import it.uniroma3.project.repository.PhotographerRepo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PhotographerServices {
	
	@Autowired
	private PhotographerRepo repo;
	
	public void add(Photographer ph) {
		this.repo.save(ph);
	}
	
	
	public Collection<Photographer> getPhotographers(){
		return this.repo.findAll();
	} 

	
	public List<Photographer> getAllPhotographersAsList(){
		return this.getPhotographers().stream().collect(Collectors.toList());
	}
	
	public Photographer getPhotograperByIdAlbum(long id) {
		return this.repo.findPhotographerByAlbumId(id);
	}
	
	public Photographer getPhotographerById(long id) {
		return this.repo.findById(id).orElse(null);
	}

}
