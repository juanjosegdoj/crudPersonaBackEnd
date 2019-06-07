package co.uco.edu.apisw.service;

import co.uco.edu.apisw.model.Persona;
import org.springframework.validation.BindException;

import java.util.List;

public interface PersonaService {

    List<Persona> listAll();

    void save(Persona persona) throws BindException;

    Persona findById(long id);

    void delete(Long id);

    void update(Persona persona) throws Exception;

}