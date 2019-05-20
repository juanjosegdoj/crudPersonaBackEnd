package co.uco.edu.pilae.torneos.restcontroller;

import co.uco.edu.pilae.torneos.entity.CategoriaEntity;
import co.uco.edu.pilae.torneos.model.Categoria;
import co.uco.edu.pilae.torneos.service.impl.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("torneo/categoria")
public class CategoriaRestController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public List<Categoria> listAll(){
        return categoriaService.listAll();
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody Categoria categoria){
        categoriaService.save(categoria);
    }

    @GetMapping("/id/{id}")
    public Categoria findById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @GetMapping("/nombre")
    public Categoria findByName(@RequestParam(required = false) String nombre) {
        return categoriaService.findByName(nombre);
    }

}
