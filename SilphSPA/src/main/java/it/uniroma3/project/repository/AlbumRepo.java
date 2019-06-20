package it.uniroma3.project.repository;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.uniroma3.project.model.Album;

@Repository
public interface AlbumRepo extends CrudRepository<Album,Long> {
	
	public Album findAlbum(String name);
	public Collection<Album> findAll();
	
	@Query("SELECT a FROM Album a JOIN FETCH a.photograph where a.id = :id")
	public Album findAlbumByPhotoId(@Param("id") long id);
	
	@Query("SELECT a FROM Album a WHERE a.photographer.id = :id")
	public List<Album> findAlbumByPhotographerId(@Param("id") long id);
	

}
