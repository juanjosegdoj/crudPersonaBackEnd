package com.tns.maraton.validators;

import static com.tns.maraton.util.TextUtil.*;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
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
        boolean isNull = validate.isNull(file);

        //Assert
        assertFalse(isNull);
    }

    @Test
    public void mustValidateFileIsNull(){
        //Arrange
        Validate validate = new Validate();
        File file = null;

        //Act
        boolean isNull = validate.isNull(file);

        //Assert
        assertTrue(isNull);
    }

    @Test
    public void mustValidateUserIsNotNull(){
        //Arrange
        Validate validate = new Validate();
        String user = "josem";

        //Act
        boolean isNull = validate.isNull(user);

        //Assert
        assertFalse(isNull);
    }

    @Test
    public void mustValidateUserIsNull(){
        //Arrange
        Validate validate = new Validate();
        String user = null;

        //Act
        boolean isNull = validate.isNull(user);

        //Assert
        assertTrue(isNull);
    }

    @Test
    public void mustValidateUserHasCorrectCharacters(){
        //Arrange
        Validate validate = new Validate();
        String user = "andersonñ_1234";

        //Act
        boolean hasCorrectCharacters = validate.hasCorrectCharacters(user);

        //Assert
        assertTrue(hasCorrectCharacters);
    }

    @Test
    public void mustValidateUserHasNotCorrectCharacters(){
        //Arrange
        Validate validate = new Validate();
        String user = "anderson_1234*";

        //Act
        boolean hasCorrectCharacters = validate.hasCorrectCharacters(user);

        //Assert
        assertFalse(hasCorrectCharacters);
    }

    @Test
    public void mustValidateUserHasSpacedCharacters(){
        //Arrange
        Validate validate = new Validate();
        String user = " anderson1234";

        //Act
        boolean hasCorrectCharacters = validate.hasCorrectCharacters(user);

        //Assert
        assertFalse(hasCorrectCharacters);
    }

    @Test
    public void mustTrimSpacesAtTheBeginningAndAtTheEndUser(){
        //Arrange
        String user = "   anderson1234   ";

        //Act
        String userTrimed = aplicateTrim(user);

        //Assert
        assertEquals("anderson1234",userTrimed);
    }

    @Test
    public void mustValidateUserHasCorrectLength(){
        //Arrange
        Validate validate = new Validate();
        String user = "anderson1234";

        //Act
        boolean userHasCorrectLength = validate.userHasCorrectLength(user);

        //Assert
        assertTrue(userHasCorrectLength);
    }

    @Test
    public void mustValidateUserHasNotLessThanFourCharacters(){
        //Arrange
        Validate validate = new Validate();
        String user = "an1";

        //Act
        boolean userHasCorrectLength = validate.userHasCorrectLength(user);

        //Assert
        assertFalse(userHasCorrectLength);
    }

    @Test
    public void mustValidateUserHasNotMoreThanTwentyCharacters(){
        //Arrange
        Validate validate = new Validate();
        String user = "anderson1234uco201811";

        //Act
        boolean userHasCorrectLength = validate.userHasCorrectLength(user);

        //Assert
        assertFalse(userHasCorrectLength);
    }

    @Test
    public void mustValidateUserDoesNotBeginsWhitNumericCharacters(){
        //Arrange
        Validate validate = new Validate();
        String user = "9anderson1234";

        //Act
        boolean userBeginsWhitANumber = validate.userBeginsWhitANumber(user);

        //Assert
        assertTrue(userBeginsWhitANumber);
    }
}
