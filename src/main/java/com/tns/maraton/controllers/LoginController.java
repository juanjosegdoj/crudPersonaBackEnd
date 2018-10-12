package com.tns.maraton.controllers;

import com.tns.maraton.exceptions.BusinessException;
import com.tns.maraton.model.response.RecognizeResponse;
import com.tns.maraton.model.response.PingResponse;
import com.tns.maraton.util.Constants;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {


    @GetMapping("/ping")
    public PingResponse ping(){
        return new PingResponse("Estás conectado!!");
    }

    @PostMapping("/register")
    public RecognizeResponse register(@RequestPart(value = "file") MultipartFile image, @RequestPart(value = "user") String user) throws IOException {
        throw new BusinessException(Constants.UNDER_CONSTRUCTION);

    }

    @PostMapping("/compare")
    public RecognizeResponse compare(@RequestPart(value = "file") MultipartFile image, @RequestPart(value = "user") String user) throws IOException {
        throw new BusinessException(Constants.UNDER_CONSTRUCTION);

    }

}
