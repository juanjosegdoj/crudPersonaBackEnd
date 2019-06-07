package co.uco.edu.apisw.converter;

import co.uco.edu.apisw.entity.PersonaEntity;
import co.uco.edu.apisw.model.Persona;
import co.uco.edu.apisw.util.validator.PersonaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonaConverter {

    @Autowired
    private PersonaValidator personaValidator;

    public Persona entityToModel(PersonaEntity personaEntity) {
        Persona persona = new Persona();

        persona.setId(personaEntity.getId());
        persona.setNombre(personaEntity.getNombre());
        persona.setApellido(personaEntity.getApellido());
        persona.setTelefono(personaEntity.getTelefono());

        return persona;
    }

    public PersonaEntity modelToEntity(Persona persona) throws BindException {
        PersonaEntity personaEntity = new PersonaEntity();

        personaEntity.setId(persona.getId());
        personaEntity.setNombre(persona.getNombre());
        personaEntity.setApellido(persona.getApellido());
        personaEntity.setTelefono(persona.getTelefono());
        personaValidator.validate(personaEntity);
        return personaEntity;
    }


    public List<Persona> entityToModel(List<PersonaEntity> personasEntity) {
        List<Persona> personas = new ArrayList<>(personasEntity.size());

        personasEntity.forEach((entity)->{
            personas.add(entityToModel(entity));
        });

        return personas;
    }
}
