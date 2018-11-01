package com.tns.maraton.services;

import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.validators.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    private static final String FILE_NAME = "julian3.jpeg";

    @InjectMocks
    private LoginService service;

    @Mock
    private MaratonClient client;

    @Mock
    private Validate validate;

    @Test(expected = BusinessException.class)
    public void registerMustCallValidator() {
        //Arange
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());

        //Act
        service.register(file, "Juan");

        //Assert
        verify(validate).isNotNull(file);
    }

    @Test
    public void mustValidateIsNotNull() {
        //Arange
        File file = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());

        //Act
        when(validate.isNotNull(file)).thenReturn(true);
        service.register(file, "Juan");

        //Assert
        verify(client).register(file,"Juan");
    }

    @Test(expected = BusinessException.class)
    public void mustValidateIsNull() {
        //Arange
        File file = null;

        //Act
        service.register(file, "Juan");

        //Assert
        verify(client, times(0)).register(file,"Juan");
    }


    @Test(expected = BusinessException.class)
    public void mustThrowAnExceptionWhenFileIsNull() {
        //Arange
        File file = null;

        //Act
        service.register(file, "Juan");

        //Assert
    }

}
