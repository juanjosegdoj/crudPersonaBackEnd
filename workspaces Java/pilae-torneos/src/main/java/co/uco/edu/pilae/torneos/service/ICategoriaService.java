package co.uco.edu.pilae.torneos.service;

import co.uco.edu.pilae.torneos.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    void save(Categoria categoria);

    List<Categoria> listAll();

    Categoria findById(long id);

    Categoria findByName(String name);
}
