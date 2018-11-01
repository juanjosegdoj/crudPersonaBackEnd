package com.tns.maraton.util;

import static com.tns.maraton.util.TextUtil.*;
import static com.tns.maraton.util.ObjectUtil.*;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObjectUtilTest {

    private static final String FILE_NAME = "julian3.jpeg";

    @Test
    public void mustValidateFileIsNotNull() {
        //Arrange
        TextUtil.Validate validate = new TextUtil.Validate();
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());

        //Act
        boolean isNull = validate.isNull(file);

        //Assert
        assertFalse(isNull);
    }

    @Test
    public void mustValidateFileIsNull(){
        //Arrange
        TextUtil.Validate validate = new TextUtil.Validate();
        File file = null;

        //Act
        boolean isNull = validate.isNull(file);

        //Assert
        assertTrue(isNull);
    }

    @Test
    public void mustValidateUserIsNotNull(){
        //Arrange
        TextUtil.Validate validate = new TextUtil.Validate();
        String user = "josem";

        //Act
        boolean isNull = validate.isNull(user);

        //Assert
        assertFalse(isNull);
    }

    @Test
    public void mustValidateUserIsNull(){
        //Arrange
        TextUtil.Validate validate = new TextUtil.Validate();
        String user = null;

        //Act
        boolean isNull = validate.isNull(user);

        //Assert
        assertTrue(isNull);
    }

}
