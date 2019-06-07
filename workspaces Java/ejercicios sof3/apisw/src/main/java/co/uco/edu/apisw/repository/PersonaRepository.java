package co.uco.edu.apisw.repository;

import co.uco.edu.apisw.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Serializable> {
}
