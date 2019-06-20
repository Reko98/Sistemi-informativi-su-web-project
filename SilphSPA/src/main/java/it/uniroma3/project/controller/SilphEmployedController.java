package it.uniroma3.project.controller;
import it.uniroma3.project.model.Photographer;
import it.uniroma3.project.service.PhotographerServices;
import it.uniroma3.project.service.UseRequestServices;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SilphEmployedController {
	
	@Autowired
	private PhotographerServices photographerServ;
	
	@Autowired
	private PhotographerValidator photographerValid;
	
	@Autowired
	private UseRequestServices requestServ;
	
	
	
	@RequestMapping(value="/UseRequestView",  method = RequestMethod.GET)
	public String getUseRequest(Model model) {
		model.addAttribute("UseRequest", this.requestServ.getAllRequest().stream().collect(Collectors.toList()));
		return "useRequest.html";
		
	}
	
	@RequestMapping(value="/newPhotographer", method=RequestMethod.GET)
	public String NewPhotographer(Model model) {
		Photographer ph = new Photographer();
		model.addAttribute("ph", ph);
		return "creatingPhotographer.html";
	}
	
	@RequestMapping(value="/addPhotographer", method = RequestMethod.GET)
	public String addPhotographer(@Valid @ModelAttribute ("ph") Photographer ph, Model model, BindingResult bindingResult) {
		this.photographerValid.validate(ph, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.photographerServ.add(ph);
			return "Photographer.html";
		}
		
		else {return "creatingPhotographer.html";}
	}
	
	/*
	 @RequestMapping(value="/creatingAlbum", method = RequestMethod.GET)
	 public String newAlbum(Model model) {
	 		return "newAlbum.html";
	 }
	 
	  
	 @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
	 public String addNewAlbum(@Valid @ModelAtribute("al") Album al, @RequesParam("photos") MultipartFile[] files, Model model, BindingResult bindingResult){
	
			
		}*/
	}
	


