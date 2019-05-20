package co.uco.edu.pilae.torneos.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "deporte_tbl")
public class DeporteEntity {

    /**
     * Representa el DeporteEntity que se va a jugar en untorneo, además de representar el
     * deporte en el que compite un equipo
     */

    @Id
    @GeneratedValue
    @Column(name = "id_deporte")
    public Long codigo;

    @Column(name = "nombre", nullable = false, length = 50)
    @Size(min = 3, max = 50)
    public String nombre;


    @Column(name = "descripcion", length = 200)
    public String descripcion;

    // private List<EquipoEntity> equipoDominios = new ArrayList<>();
    // private List<TorneoEntity> torneoDominios = new ArrayList<>();


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
