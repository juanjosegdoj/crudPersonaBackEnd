package co.edu.uco.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.apirest.domain.Persona;
import co.edu.uco.apirest.service.PersonaService;

@RestController("GenericRest")
@RequestMapping("/servicio")
public class GenericRest {
	
	@Autowired
	@Qualifier("PersonaServiceImpl"	)
	PersonaService personaService;	
	
	@GetMapping("/saludo")
	public String saludar() {
		return "hola mundo";
	}
	
	@GetMapping("/holi")
	public List<Persona> listPersona(){
		return personaService.listAll();
	}
}
