package co.uco.edu.apisw.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "persona")
@Data
public class PersonaEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Apellido no puede ser vacío")
    @Size(min = 3, max = 50, message = "Tamaño de nombre no válido")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotEmpty(message = "Apellido no puede ser vacío")
    @Size(min = 3, max = 50, message = "Tamaño de apellido no válido")
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @NotEmpty(message = "Telefono no puede ser vacío")
    @Size(min = 3, max = 20, message = "Telefono de apellido no válido")
    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;


}