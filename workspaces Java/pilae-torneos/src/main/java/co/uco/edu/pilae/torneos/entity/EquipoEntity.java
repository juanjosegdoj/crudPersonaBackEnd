package co.uco.edu.pilae.torneos.entity;

import co.uco.edu.pilae.torneos.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.uco.edu.pilae.torneos.utilitarios.excepcion.excepcion.AplicacionExcepcion;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import static co.uco.edu.pilae.torneos.utilitarios.cadenas.UtilText.getUtilText;
import static co.uco.edu.pilae.torneos.utilitarios.objeto.UtilObject.getUtilObject;


@Table(name = "equipo_tbl")
public class EquipoEntity {

    /**
     * Son los equipos los cuales van a competir en un torneo
     */

    private Long codigo;
    private String nombre;
    private List<JugadorEntity> jugadores = new ArrayList<>();
    private GeneroEntity generoEntity;
    private DeporteEntity deporteEntity;
    private CategoriaEntity categoriaEntity;

    public EquipoEntity() {
        super();
    }

    public EquipoEntity(Long codigo, String nombre, GeneroEntity generoEntity, DeporteEntity deporteEntity, CategoriaEntity categoriaEntity) {
        setCodigo(codigo);
        setNombre(nombre);
        setGeneroEntity(generoEntity);
        setDeporteEntity(deporteEntity);
        setCategoriaEntity(categoriaEntity);
    }


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;

        if(codigo <1){
            final String mensajeUsuario = "Se ha presentado un problema tratando de registrar el EquipoEntity";
            final String mensajeTecnico = "El nombre de un EquipoEntity tiene que tener mínimo 2 caracteres";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        if(getUtilText().applyTrim(this.nombre).length() < 2){
            final String mensajeUsuario = "Se ha presentado un problema tratando de registrar el EquipoEntity";
            final String mensajeTecnico = "El nombre de un EquipoEntity tiene que tener mínimo 2 caracteres";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
    }

    public List<JugadorEntity> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorEntity> jugadores) {
        this.jugadores = jugadores;
    }

    public GeneroEntity getGeneroEntity() {
        return generoEntity;
    }

    public void setGeneroEntity(GeneroEntity generoEntity) {
        this.generoEntity = generoEntity;
        if(getUtilObject().objetoEsNulo(generoEntity)){
            final String mensajeUsuario = "Se ha presentado un problema tratando de registrar el EquipoEntity";
            final String mensajeTecnico = "El equipo tiene que tener un Género asociado";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
    }

    public DeporteEntity getDeporteEntity() {
        return deporteEntity;
    }

    public void setDeporteEntity(DeporteEntity deporteEntity) {
        this.deporteEntity = deporteEntity;
        if(getUtilObject().objetoEsNulo(deporteEntity)){
            final String mensajeUsuario = "Se ha presentado un problema tratando de registrar el EquipoEntity";
            final String mensajeTecnico = "El equipo tiene que tener un DeporteEntity asociado";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
    }

    public CategoriaEntity getCategoriaEntity() {
        return categoriaEntity;
    }

    public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
        this.categoriaEntity = categoriaEntity;
        if(getUtilObject().objetoEsNulo(categoriaEntity)){
            final String mensajeUsuario = "Se ha presentado un problema tratando de registrar el EquipoEntity";
            final String mensajeTecnico = "El equipo tiene que tener un CategoriaEntity asociado";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
    }
}
