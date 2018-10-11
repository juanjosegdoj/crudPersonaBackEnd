package com.tns.maraton.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepository {

    private static List<String> buffer = new ArrayList<String>();

    public void save(String user) {
        buffer.add(user);
    }

    public List<String> findAll(){
        return buffer;
    }

}
