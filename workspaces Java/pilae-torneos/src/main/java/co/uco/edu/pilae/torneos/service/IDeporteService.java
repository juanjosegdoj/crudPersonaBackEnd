package co.uco.edu.pilae.torneos.service;

import co.uco.edu.pilae.torneos.model.Deporte;

import java.util.List;

public interface IDeporteService {

    void save(Deporte deporte);

    List<Deporte> listAll();

    Deporte findById(long id);
}
