package it.uniroma3.project.repository;
import it.uniroma3.project.model.UseRequest;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRequestRepo extends CrudRepository<UseRequest, Long> {
	
	public Collection<UseRequest> findAll();
	
	@Query("SELECT r FROM UseRequest r JOIN FETCH r.photograph f WHERE f.id = :id")
	public UseRequest findByPhotoId(@Param("id") Long id);

}
