package co.uco.edu.pilae.torneos.service.impl;

import co.uco.edu.pilae.torneos.converter.GeneroConverter;
import co.uco.edu.pilae.torneos.entity.GeneroEntity;
import co.uco.edu.pilae.torneos.model.Genero;
import co.uco.edu.pilae.torneos.repository.GeneroRespository;
import co.uco.edu.pilae.torneos.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGeneroService {

    @Autowired
    private GeneroRespository generoRespository;

    @Autowired
    private GeneroConverter generoConverter;

    public List<Genero> listAll(){
        return generoConverter.entityToModel(generoRespository.findAll());
    }

    public Genero findById(long id){
        return generoConverter.entityToModel(generoRespository.findById(id).orElse(null));
    }
}
