package org.descartes.web;

import java.util.List;

import org.descartes.domain.Personne;
import org.descartes.services.ServicePersonne;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@EnableAutoConfiguration 
public class RestWebService {
	
	ServicePersonne servicePersonne = new ServicePersonne();

	@RequestMapping(value = "/personne", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<?> getPersonne(){
		return servicePersonne.findAll();
	}
	
	@RequestMapping(value = "/personne/{nom}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Personne getPersonne(@PathVariable("nom") String nom){
		return servicePersonne.findPersonne(nom);
	}
	
	@RequestMapping(value = "/personne", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void postPersonne(@RequestBody Personne personne){
		System.out.println(personne);
		servicePersonne.addPersonne(personne);
	}
}
