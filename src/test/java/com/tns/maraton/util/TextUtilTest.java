package com.tns.maraton.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TextUtilTest {

    @Test
    public void mustValidateUserHasCorrectCharacters(){
        //Arrange
        String user = "andersonñ_1234";

        //Act
        boolean hasCorrectCharacters = TextUtil.hasCorrectCharacters(user);

        //Assert
        assertTrue(hasCorrectCharacters);
    }

    @Test
    public void mustValidateUserHasNotCorrectCharacters(){
        //Arrange
        String user = "anderson_1234*";

        //Act
        boolean hasCorrectCharacters = TextUtil.hasCorrectCharacters(user);

        //Assert
        assertFalse(hasCorrectCharacters);
    }

    @Test
    public void mustValidateUserHasSpacedCharacters(){
        //Arrange
        String user = " anderson1234";

        //Act
        boolean hasCorrectCharacters = TextUtil.hasCorrectCharacters(user);

        //Assert
        assertFalse(hasCorrectCharacters);
    }

    @Test
    public void mustTrimSpacesAtTheBeginningAndAtTheEndUser(){
        //Arrange
        String user = "   anderson1234   ";

        //Act
        String userTrimed = TextUtil.aplicateTrim(user);

        //Assert
        assertEquals("anderson1234",userTrimed);
    }

    @Test
    public void mustValidateUserHasCorrectLength(){
        //Arrange
        String user = "anderson1234";

        //Act
        boolean userHasCorrectLength = TextUtil.userHasCorrectLength(user);

        //Assert
        assertTrue(userHasCorrectLength);
    }

    @Test
    public void mustValidateUserHasNotLessThanFourCharacters(){
        //Arrange
        String user = "an1";

        //Act
        boolean userHasCorrectLength = TextUtil.userHasCorrectLength(user);

        //Assert
        assertFalse(userHasCorrectLength);
    }

    @Test
    public void mustValidateUserHasNotMoreThanTwentyCharacters(){
        //Arrange
        String user = "anderson1234uco201811";

        //Act
        boolean userHasCorrectLength = TextUtil.userHasCorrectLength(user);

        //Assert
        assertFalse(userHasCorrectLength);
    }

    @Test
    public void mustValidateUserDoesNotBeginsWhitNumericCharacters(){
        //Arrange
        String user = "9anderson1234";

        //Act
        boolean userBeginsWhitANumber = TextUtil.userBeginsWhitANumber(user);

        //Assert
        assertTrue(userBeginsWhitANumber);
    }
}
