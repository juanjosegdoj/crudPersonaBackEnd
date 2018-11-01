package com.tns.maraton.validators;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    private static final String FILE_NAME = "julian3.jpeg";

    @Test
    public void mustValidateFileIsNotNull() {
        //Arrange
        Validate validate = new Validate();
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());

        //Act
        boolean isNotNull = validate.isNotNull(file);

        //Assert
        assertTrue(isNotNull);
    }

    @Test
    public void mustValidateIsNull(){
        //Arrange
        Validate validate = new Validate();
        File file = null;

        //Act
        boolean isNull = validate.isNotNull(file);

        //Assert
        assertFalse(isNull);
    }
}
