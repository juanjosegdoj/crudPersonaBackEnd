package com.tns.maraton.repositories;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersReposittory {

    private static List<String> buffer;

    public UsersReposittory(){
        buffer = new ArrayList<String>();
    }

    public void save(String user) {
        buffer.add(user);
    }

    public List<String> findAll(){
        return buffer;
    }

}
