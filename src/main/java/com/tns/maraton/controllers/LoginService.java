package com.tns.maraton.controllers;


import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.model.response.RecognizeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class LoginService {

    @Autowired
    private MaratonClient client;


    public RecognizeResponse compare(File file, String user) {
        return client.compare(file, user);
    }

    public RecognizeResponse register(File file, String user) {
        return client.register(file, user);
    }
}
