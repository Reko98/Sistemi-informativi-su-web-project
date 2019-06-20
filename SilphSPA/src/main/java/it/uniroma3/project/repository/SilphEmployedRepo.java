package it.uniroma3.project.repository;
import it.uniroma3.project.model.SilphEmployed;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SilphEmployedRepo extends CrudRepository<SilphEmployed, Long>{
	public Collection<SilphEmployed> findAll();
	
	public SilphEmployed findEmployee(String username);
	
	public SilphEmployed findByUsernameAndPassword(String uname, String pwd);
	

}
