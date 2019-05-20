package co.uco.edu.pilae.torneos.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@Entity
@Table(name = "categoria_tbl")
public class CategoriaEntity {

    /**
     * Representa un rango de edades, el cual corresponde a los jugadores aptos para
     * participar en un torneo que asocie esta clase
     */

    @Id
    @GeneratedValue
    @Column(name = "id_categoria")
    private Long codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_minima")
    @Temporal(TemporalType.DATE) @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-CO", timezone = "America/Bogota")
    private Calendar fechaMinima;  // Indica la menor edad permitida

    @Column(name = "fecha_maxima")
    @Temporal(TemporalType.DATE) @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-CO", timezone = "America/Bogota")
    private Calendar fechaMaxima;  // Indica la mayor edad perimitida

    @OneToMany(mappedBy = "CategoriaEntity", cascade = CascadeType.ALL)
    private List<TorneoEntity> torneos = new ArrayList<>();

    //private List<EquipoEntity> equipos = new ArrayList<>();


}
