package co.uco.edu.apisw.util.validator;

import co.uco.edu.apisw.entity.PersonaEntity;
import co.uco.edu.apisw.util.validator.generic.GenericValidator;
import org.springframework.stereotype.Component;

@Component
public class PersonaValidator extends GenericValidator<PersonaEntity> {

    public PersonaValidator() {
        super();
    }

}
