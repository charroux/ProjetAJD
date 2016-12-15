package org.descartes.web;

import java.util.List;

import location.Car;

import org.descartes.domain.Personne;
import org.descartes.services.ServicePersonne;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	public void postPersonne(Personne personne){
		servicePersonne.addPersonne(personne);
	}
}
