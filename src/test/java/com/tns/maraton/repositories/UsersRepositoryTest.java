package com.tns.maraton.repositories;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(value = SpringJUnit4ClassRunner.class)
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository repository;

    @Test
    public void mustAddUser(){
        repository.save("Julian");
        assertTrue(repository.findAll().size()>0);

    }

}
