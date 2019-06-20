package it.uniroma3.project.service;
import it.uniroma3.project.model.SilphEmployed;
import it.uniroma3.project.repository.SilphEmployedRepo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SilphEmployedServices {
	
	@Autowired
	private SilphEmployedRepo repo;
	
	public void addEmployee(SilphEmployed empl) {
		this.repo.save(empl);
	}
	
	public SilphEmployed getEmployedByUsername(String uname) {
		return this.repo.findEmployee(uname);
	}
	
	public Collection<SilphEmployed> getAllEmployees(){
		return this.repo.findAll();
	}
	
	//para obtener una lista de los valores en MODO lista... Es util???
	public List<SilphEmployed> getEmployeesList(){
		return this.getAllEmployees().stream().collect(Collectors.toList());
	}
	
	public SilphEmployed getEmployedById(long id) {
		return this.repo.findById(id).orElse(null);
	}

}
