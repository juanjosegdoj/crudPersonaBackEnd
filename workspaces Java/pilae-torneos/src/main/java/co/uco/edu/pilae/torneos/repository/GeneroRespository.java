package co.uco.edu.pilae.torneos.repository;

import co.uco.edu.pilae.torneos.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface GeneroRespository extends JpaRepository<GeneroEntity, Serializable> {
}
