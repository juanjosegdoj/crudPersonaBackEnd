package com.tns.maraton.validators;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class Validate {

    public boolean isNotNull(File file) {
        return file != null;
    }
}
