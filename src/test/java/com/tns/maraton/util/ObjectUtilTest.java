package com.tns.maraton.util;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObjectUtilTest {

    private static final String FILE_NAME = "julian3.jpeg";

    @Test
    public void mustValidateFileIsNotNull() {
        //Arrange
        ObjectUtil objectUtil = new ObjectUtil();
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());

        //Act
        boolean isNull = objectUtil.isNull(file);

        //Assert
        assertFalse(isNull);
    }

    @Test
    public void mustValidateFileIsNull(){
        //Arrange
        ObjectUtil objectUtil = new ObjectUtil();
        File file = null;

        //Act
        boolean isNull = objectUtil.isNull(file);

        //Assert
        assertTrue(isNull);
    }

    @Test
    public void mustValidateUserIsNotNull(){
        //Arrange
        ObjectUtil objectUtil = new ObjectUtil();
        String user = "josem";

        //Act
        boolean isNull = objectUtil.isNull(user);

        //Assert
        assertFalse(isNull);
    }

    @Test
    public void mustValidateUserIsNull(){
        //Arrange
        ObjectUtil objectUtil = new ObjectUtil();
        String user = null;

        //Act
        boolean isNull = objectUtil.isNull(user);

        //Assert
        assertTrue(isNull);
    }

}
