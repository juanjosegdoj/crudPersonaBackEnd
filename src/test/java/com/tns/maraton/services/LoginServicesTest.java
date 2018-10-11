package com.tns.maraton.services;

import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.repositories.UsersRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(value = MockitoJUnitRunner.class)
public class LoginServicesTest {

    @InjectMocks
    private LoginServices loginServices;

    @Mock
    private MaratonClient client;

    @Mock
    private UsersRepository repository;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void mustCallService(){
        when(client.register(new File(""), "HOLA")).thenReturn(new RecognizeResponse());
        RecognizeResponse response = loginServices.register(new File(""), "HOLA");
        Assert.assertTrue(null!=response);
    }

    @Test
    public void mustAddUser(){
        when(client.register(new File(""), "HOLA")).thenReturn(new RecognizeResponse());
        loginServices.register(new File(""), "HOLA");
        verify(repository).save("HOLA");

    }
}
