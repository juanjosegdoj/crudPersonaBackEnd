package co.uco.edu.apisw.restcontroller;

import co.uco.edu.apisw.entity.PersonaEntity;
import co.uco.edu.apisw.model.Persona;
import co.uco.edu.apisw.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PersonaRestController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/listar")
    public List<Persona> listAll() {
        return personaService.listAll();
    }

    @PostMapping("/insertar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> insertar(@RequestBody Persona persona) {

        Map<String, Object> response = new HashMap<>();
        HttpStatus status;

        try {
            personaService.save(persona);
            response.put("Mensaje", "La información se ha insertado exitosamente.");
            status = HttpStatus.CREATED;
        } catch (BindException e) {
            response.put("Causa", e.getObjectName().toString());
            response.put("Mensaje", "No se pudo insertar la información");
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/persona/{id}")
    public Persona findById(@PathVariable long id) {
        return personaService.findById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id){
        personaService.delete(id);
    }

    @PutMapping("/actualizar")
    public void update(@RequestBody Persona persona){
        try {
            personaService.update(persona);
        } catch (Exception excepcion){
            System.out.println("Ha ocurrido un error.");
        }
    }
}