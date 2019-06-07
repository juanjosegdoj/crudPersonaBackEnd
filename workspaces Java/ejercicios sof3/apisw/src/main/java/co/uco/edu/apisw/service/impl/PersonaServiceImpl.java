package co.uco.edu.apisw.service.impl;

import co.uco.edu.apisw.converter.PersonaConverter;
import co.uco.edu.apisw.entity.PersonaEntity;
import co.uco.edu.apisw.model.Persona;
import co.uco.edu.apisw.repository.PersonaRepository;

import co.uco.edu.apisw.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaConverter personaConverter;

    @Override
    public List<Persona> listAll() {
        return personaConverter.entityToModel(personaRepository.findAll());
    }

    @Override
    public void save(Persona persona) throws BindException {
        personaRepository.save(personaConverter.modelToEntity(persona));
    }

    @Override
    public Persona findById(long id) {
        return personaConverter.entityToModel(personaRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(Long id){
        personaRepository.deleteById(id);
    }

    @Override
    public void update(Persona persona) throws Exception{

        Optional<PersonaEntity> personaEntity = personaRepository.findById(persona.getId());

        if(personaEntity.isPresent()){
            personaEntity.get().setNombre(persona.getNombre());
            personaEntity.get().setApellido(persona.getApellido());
            personaEntity.get().setTelefono(persona.getTelefono());

            personaRepository.save(personaEntity.get());
        }else{
            throw new Exception("No se encontró la persona que quiere actualizar");
        }


    }
}