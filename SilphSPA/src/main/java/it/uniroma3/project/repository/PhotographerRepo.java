package it.uniroma3.project.repository;
import it.uniroma3.project.model.Photographer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PhotographerRepo extends CrudRepository<Photographer, Long>{
	public Collection<Photographer> findAll();
	
	@Query("SELECT f FROM Photographer f JOIN FETCH f.album a WHERE a.id = :id")
	public Photographer findPhotographerByAlbumId(@Param("id") long id);
	
}
