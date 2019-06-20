package it.uniroma3.project.repository;
import it.uniroma3.project.model.Photograph;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DBPopulation extends CrudRepository<Photograph, Long> {
	
	public Collection<Photograph> findAll();
	
	@Query("SELECT ph FROM Photograph ph JOIN FETCH ph.photographer photer WHERE photer.id =:id")
	public Collection<Photograph>findPhotoByPhotographerId(@Param("id") Long id);
	
	public Photograph findPhoto(String name);
	
	//FindPhotoByImage??

	
	
}	
	
	
	
	
	
	/*@Autowired
	private SilphEmployedRepo employeesRepo;
	@Autowired
	private PhotographerRepo photographerRepo;
	@Autowired
	private PhotographRepo photoRepo;
	@Autowired
	private UseRequestRepo requestRepo;
	
	@Override
	public void run(ApplicationArguments arg) throws Exception{
		this.removeEmployees();
		this.removePhotographers();
		this.removePhotos();
		this.removeRequests();
		
		this.addEmployees();
		this.addPhotographers();
		this.addPhotos();
		this.addRequests();
	}
	
	
	private void addEmployees() {
		SilphEmployed emp = new SilphEmployed();
		
		emp.setName("Simone");
		emp.setSurname("Durante");
		emp.setUsername("SimoDurante");
		emp.setPassword("nah");
		
		this.employeesRepo.save(emp);
	}
	
	private void addPhotographers() {
		Photographer ph1 = new Photographer("Francis", "Irime", "firime@hotmail.com");
		Photographer ph2 = new Photographer("Fernando", "Gonzalez", "fgonzalez@hotmail.com");
		Photographer ph3 = new Photographer("Roberto", "Antonelli", "rantonelli@hotmail.com");
		Photographer ph4 = new Photographer("Alejandro", "Colombo", "acolombo@hotmail.com");

		this.photographerRepo.save(ph1);
		this.photographerRepo.save(ph2);
		this.photographerRepo.save(ph3);
		this.photographerRepo.save(ph4);
		
	}

	private void addPhotos() {
		
	}
	
	private void addRequests() {}
	
	
	private void removeEmployees() {}
	
	private void removePhotos() {}
	
	private void removePhotographers() {}
	
	private void removeRequests() {}
}
*/