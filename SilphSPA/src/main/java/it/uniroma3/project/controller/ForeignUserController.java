package it.uniroma3.project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.project.model.Album;
import it.uniroma3.project.model.Photograph;
import it.uniroma3.project.model.Photographer;
import it.uniroma3.project.model.SilphEmployed;
import it.uniroma3.project.model.UseRequest;
import it.uniroma3.project.service.AlbumServices;
import it.uniroma3.project.service.PhotographServices;
import it.uniroma3.project.service.PhotographerServices;
import it.uniroma3.project.service.SilphEmployedServices;
import it.uniroma3.project.service.UseRequestServices;

@Controller
public class ForeignUserController {
	@Autowired
	private AlbumServices albumServ;
	
	@Autowired
	private PhotographServices photoServ;
	
	@Autowired
	private PhotographerServices photographerServ;
	
	@Autowired
	private UseRequestServices requestServ;

	@Autowired 
	private UseRequestValidator requestValidator;
	
	@Autowired
	private SilphEmployedServices silphEmp;
	
	
	//////Incomplete
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("employee") SilphEmployed emp, Model model) {
		return "login.html";
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String getIndex() {
			return "index.html";
		}
	
	
	@RequestMapping(value="/PhotoGallery", method=RequestMethod.GET )
	public String addNewGallery(Model model) {
		model.addAttribute("photos",this.photoServ.getAllPhotosList());
		model.addAttribute("useRequest", new UseRequest());
		return "gallery.html";	
	}
	
	@RequestMapping(value="/Photographers", method=RequestMethod.GET)
	public String getPhotographers(Model model) {
		List<Photographer> photographers = (List<Photographer>) this.photographerServ.getAllPhotographersAsList();
		int dimension = photographers.size()/3;
		List<Photographer> ph1 = photographers.subList(0, dimension);
		List<Photographer> ph2 = photographers.subList(dimension, dimension*2);
		List<Photographer> ph3 = photographers.subList(dimension*2, dimension*3);
		model.addAttribute("ph1", ph1);
		model.addAttribute("ph2", ph2);
		model.addAttribute("ph3", ph3);
		return "photographers.html";

		
	}
	
	@RequestMapping(value="/getPhoto/{id}", method=RequestMethod.GET)
	public void getPhoto(@PathVariable ("id") Long id, Model model, HttpServletResponse response)throws IOException{
		response.setContentType("image/jpg, image/png");
		Photograph ph = this.photoServ.getPhotoById(id);
		response.getOutputStream().write(ph.getImageSrc());
		response.getOutputStream().close();	
	}
	
	@RequestMapping(value="/getPhotographer/{id}", method=RequestMethod.GET)
	public String getPhotographer(@PathVariable ("id") long id, Model model) {
		model.addAttribute("photographer", this.photographerServ.getPhotographerById(id));
		model.addAttribute("albums", this.albumServ.getAlbumByPhotographerId(id));
		return "getPhotographer.html";
	}
	
	@RequestMapping(value="/album/{id}", method=RequestMethod.GET)
	public String getAlbum(@PathVariable ("id") long id, Model model) {
		Album alb = this.albumServ.getAlbumById(id);
		model.addAttribute("album", alb);
		model.addAttribute("Photographs", alb.getPhotograph());
		model.addAttribute("useRequest", new UseRequest());
		return "album.html";
	}
	
	@RequestMapping(value="/useRequestView", method=RequestMethod.POST)
	public String useRequestForm(@ModelAttribute("useRequest") UseRequest request, Model model, BindingResult result) {
		this.requestValidator.validate(requestServ, result);
		if(!result.hasErrors()) {
			request.setDate(LocalDate.now());
			this.requestServ.add(request);
		}
		
		model.addAttribute("photos", this.photoServ.getAllPhotosList());
		
		return "gallery.html";
	}
	
	
	
	
	
	
	
}
	
	