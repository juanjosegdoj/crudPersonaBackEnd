package co.uco.edu.pilae.torneos.repository;

import co.uco.edu.pilae.torneos.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Serializable> {

    @Query("FROM CategoriaEntity as cat WHERE cat.nombre=?1")
    CategoriaEntity findByName(String nombreCategoria);

}
