package com.tns.maraton.services;

import com.tns.maraton.client.MaratonClient;
import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.repositories.UsersRepository;
import com.tns.maraton.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class LoginServices {

    @Autowired
    private MaratonClient client;

    @Autowired
    private UsersRepository repository;

    public RecognizeResponse register(File imageFile, String user) {
        repository.save(user);
        return client.register(imageFile, user);
    }

    public RecognizeResponse compare(File imageFile, String user) {
        throw new BusinessException(Constants.UNDER_CONSTRUCTION);
    }
}
