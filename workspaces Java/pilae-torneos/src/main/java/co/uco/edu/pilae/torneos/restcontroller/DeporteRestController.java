package co.uco.edu.pilae.torneos.restcontroller;

import co.uco.edu.pilae.torneos.model.Deporte;
import co.uco.edu.pilae.torneos.service.impl.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneo/deporte")
public class DeporteRestController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/listar")
    public List<Deporte> listAll(){return deporteService.listAll();
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody Deporte deporte) {
        deporteService.save(deporte);
    }

    @GetMapping("/deporte/{id}")
    public Deporte findById(@PathVariable long id) {
        return deporteService.findById(id);
    }

}
