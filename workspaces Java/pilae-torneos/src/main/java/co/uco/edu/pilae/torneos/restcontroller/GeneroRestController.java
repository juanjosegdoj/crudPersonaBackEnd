package co.uco.edu.pilae.torneos.restcontroller;

import co.uco.edu.pilae.torneos.entity.GeneroEntity;
import co.uco.edu.pilae.torneos.model.Genero;
import co.uco.edu.pilae.torneos.service.impl.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/torneo/genero")
public class GeneroRestController {

    @Autowired
    private GeneroService generoService;

    @GetMapping("/listar")
    public List<Genero> listAll(){
        return generoService.listAll();
    }

    @GetMapping("/{id}")
    public Genero findById(@PathVariable long id){
        return generoService.findById(id);
    }
}
