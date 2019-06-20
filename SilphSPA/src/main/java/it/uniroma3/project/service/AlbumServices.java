package it.uniroma3.project.service;
import it.uniroma3.project.model.Album;
import it.uniroma3.project.repository.AlbumRepo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AlbumServices {
	
	@Autowired
	private AlbumRepo repo;
	
	public void add(Album album) {
		this.repo.save(album);
		
	}
	
	public Album getAlbumByName(String name) {
		return this.repo.findAlbum(name);
	}
	
	public Album getAlbumByPhotoId(Long id) {
		return this.repo.findAlbumByPhotoId(id);
	}
	
	public Collection<Album> getAll(){
		return this.repo.findAll();
	}
	
	public List<Album> getAlbumsList(){
		return this.getAll().stream().collect(Collectors.toList());
	}
	
	public List<Album> getAlbumByPhotographerId(Long id){
		return this.repo.findAlbumByPhotographerId(id);
	}
	
	public Album getAlbumById(long id) {
		return this.repo.findById(id).orElse(null);
	}

}
