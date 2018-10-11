package com.tns.maraton.services;

import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.util.Constants;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class LoginServices {

    public RecognizeResponse register(File imageFile, String user) {
        throw new BusinessException(Constants.UNDER_CONSTRUCTION);
    }

    public RecognizeResponse compare(File imageFile, String user) {
        throw new BusinessException(Constants.UNDER_CONSTRUCTION);
    }
}