package co.uco.edu.pilae.torneos.service;

import co.uco.edu.pilae.torneos.model.Genero;

import java.util.List;

public interface IGeneroService {

    List<Genero> listAll();

    Genero findById(long id);
}
