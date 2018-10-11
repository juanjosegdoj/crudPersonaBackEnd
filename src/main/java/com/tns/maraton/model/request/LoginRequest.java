package com.tns.maraton.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {

    private byte[] file;
    private String user;

    public byte[] getFile() {
        return file.clone();
    }

    public void setFile(byte[] file) {
        this.file = file.clone();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
