package it.uniroma3.project.repository;
import it.uniroma3.project.model.Photograph;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographRepo extends CrudRepository<Photograph, Long> {
	public Collection<Photograph> findAll();
	
	@Query("SELECT ph FROM  Photograph ph JOIN FECTH ph.Photograph phot WHERE phot.id = :id")
	public Collection<Photograph> FindPhotoByPhotographerId(@Param("id") Long id);
	
	public Photograph findPhoto(String name);

}
