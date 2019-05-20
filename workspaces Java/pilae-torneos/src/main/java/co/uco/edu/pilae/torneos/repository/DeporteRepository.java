package co.uco.edu.pilae.torneos.repository;

import co.uco.edu.pilae.torneos.entity.DeporteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface DeporteRepository extends JpaRepository<DeporteEntity, Serializable> {

    @Query("FROM DeporteEntity as dep WHERE dep.nombre=?1")
    DeporteEntity findByName(String nombreDeporte);

}
