package co.edu.uco.apirest.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.apirest.domain.Persona;
import co.edu.uco.apirest.service.PersonaService;

@Service("PersonaServiceImpl")
public class PersonaServiceImpl implements PersonaService {

	@Override
	public List<Persona> listAll() {
		
		List<Persona> personas = new ArrayList<>(); 
		personas.add(new Persona("Juan", "Giraldo"));
		personas.add(new Persona("José", "Jiménez"));
		personas.add(new Persona("Afedo", "Camate"));
		personas.add(new Persona("Guata", "Boku"));

		return personas;
	}

}
