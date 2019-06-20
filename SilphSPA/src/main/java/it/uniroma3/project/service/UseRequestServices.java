package it.uniroma3.project.service;
import it.uniroma3.project.model.UseRequest;
import it.uniroma3.project.repository.UseRequestRepo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UseRequestServices {
	
	@Autowired
	private UseRequestRepo repo;
	
	public void add(UseRequest request) {
		this.repo.save(request);
	}
	
	public UseRequest getRequestById(long id) {
		return this.repo.findByPhotoId(id);
	}
	
	public Collection<UseRequest> getAllRequest(){
		return this.repo.findAll();
	}

}
