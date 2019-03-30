package co.edu.uco.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.edu.uco.apirest.service.PersonaService;

@Controller("IndexController")
@RequestMapping("/pages")
public class IndexController {
	
	@Autowired
	@Qualifier("PersonaServiceImpl")
	PersonaService personaService;	
	
	@GetMapping("/home")
	public ModelAndView showIndex() {
		
		ModelAndView view = new ModelAndView("index");
		view.addObject("saludo", "'Estudien vagos' - philosopy: Maria Ferenanda Cabal");
		view.addObject("listaPersonas", personaService.listAll());
		return view;
	}
	
}
