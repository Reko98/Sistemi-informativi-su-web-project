package it.uniroma3.project.service;
import it.uniroma3.project.model.Photograph;
import it.uniroma3.project.repository.PhotographRepo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PhotographServices {
	
	@Autowired
	private PhotographRepo repo;
	
	public void add(Photograph ph) {
		this.repo.save(ph);
	}
	
	public Photograph getPhotoByName(String name) {
		return this.repo.findPhoto(name);
	}
	
	public Collection<Photograph>getAllPhotos(){
		return this.repo.findAll();
	}
	
	public List<Photograph> getAllPhotosList(){
		return this.getAllPhotos().stream().collect(Collectors.toList());
	}
	
	public Photograph getPhotoById(Long id) {
		return this.repo.findById(id).orElse(null);
	}

}
