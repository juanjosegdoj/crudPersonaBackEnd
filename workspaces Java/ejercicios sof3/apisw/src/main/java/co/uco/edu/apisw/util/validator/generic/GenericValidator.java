package co.uco.edu.apisw.util.validator.generic;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import javax.validation.*;

@Component
public class GenericValidator<T> {

    public GenericValidator() {
        super();
    }

    public void validate(T entity) throws BindException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        for(ConstraintViolation<T> violation : validator.validate(entity)){
            throw new BindException("Validation error", violation.getMessage());
        }
    }

}
