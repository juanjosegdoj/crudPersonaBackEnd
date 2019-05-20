package co.uco.edu.pilae.torneos.entity;

import co.uco.edu.pilae.torneos.model.Genero;
import co.uco.edu.pilae.torneos.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.uco.edu.pilae.torneos.utilitarios.excepcion.excepcion.AplicacionExcepcion;
import lombok.Data;

import javax.persistence.*;

import static co.uco.edu.pilae.torneos.utilitarios.cadenas.UtilText.getUtilText;
import static co.uco.edu.pilae.torneos.utilitarios.objeto.UtilObject.getUtilObject;



import java.util.Calendar;

@Data
@Entity
@Table(name = "jugador_tbl")
public class JugadorEntity {

    /**
     * Representa los integrantes de un equipoEntity, siendo cada uno de estos participantes de un torneo.
     */

    @Id
    @GeneratedValue
    @Column(name = "id_jugador")
    private Long codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimientp")
    private Calendar fechaNacimiento;


    @ManyToOne
    @JoinColumn(name = "id_genero")
    private GeneroEntity generoEntity;

//    private EquipoEntity equipoEntity;



    /*
    public EquipoEntity getEquipoEntity() {
        return equipoEntity;
    }

    public void setEquipoEntity(EquipoEntity equipoEntity) {
        if(getUtilObject().objetoEsNulo(equipoEntity)){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un JugadorEntity.";
            final String mensajeTecnico = "El JugadorEntity tiene que estar asociado a algún equipoEntity.";
            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.equipoEntity = equipoEntity;
    }

     */
}
