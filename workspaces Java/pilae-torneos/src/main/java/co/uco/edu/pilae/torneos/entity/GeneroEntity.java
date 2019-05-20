package co.uco.edu.pilae.torneos.entity;

import co.uco.edu.pilae.torneos.model.Genero;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "genero_tbl")
@Data
public class GeneroEntity {
    /**
     * Representa el sexo de un jugador ya sea maculino, femenino o mixto, además también representa
     * si un torneo es masculino o femenino.
     */
    @Id
    @GeneratedValue
    @Column(name = "id_genero")
    private Long codigo;


    @Size(min = 3, max = 30)
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "GeneroEntity", cascade = CascadeType.ALL)
    private List<Genero> jugadores;

}
