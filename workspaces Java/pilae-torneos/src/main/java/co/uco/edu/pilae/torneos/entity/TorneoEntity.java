package co.uco.edu.pilae.torneos.entity;

import co.uco.edu.pilae.torneos.utilitarios.estado.enumeracion.EstadoEnum;
import co.uco.edu.pilae.torneos.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.uco.edu.pilae.torneos.utilitarios.excepcion.excepcion.AplicacionExcepcion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static co.uco.edu.pilae.torneos.utilitarios.cadenas.UtilText.getUtilText;
import static co.uco.edu.pilae.torneos.utilitarios.objeto.UtilObject.getUtilObject;

public class TorneoEntity {

    /**
     * Integra todas las funcionalidades de un torneo, tales como la administación de los
     * jugadores y equipoEntityEntities que pueden hacer parte de un torneo, basados en la cantidad mínima y
     * máxima de jugaodores de un equipo por torneo.
     */

    private String nombre;
    private String descripcion;
    private DeporteEntity deporteEntity;
    private CategoriaEntity categoriaEntity;
    private EstadoEnum estado;
    private GeneroEntity generoEntity;
    private List<EquipoEntity> equipoEntityEntities = new ArrayList<>();
    private Calendar fechaIncio;
    private int maxJugaoresPorEquipo;   // Cantidad de jugadores máximamente permitidos en un equipo de un torneo
    private int minJugadoresPorEquipo;  // Cantidad de jugadores máximamente permitidos en un equipo de un torneo

    public TorneoEntity() {
        super();
    }

    public TorneoEntity(String nombre, String descripcion, DeporteEntity deporteEntity, CategoriaEntity categoriaEntity,
                        EstadoEnum estado, GeneroEntity generoEntity, Calendar fechaIncio, int maxJugaoresPorEquipo, int minJugadoresPorEquipo) {

        setNombre(nombre);
        setDescripcion(descripcion);
        setDeporteEntity(deporteEntity);
        setCategoriaEntity(categoriaEntity);
        setEstado(estado);
        setGeneroEntity(generoEntity);
        setFechaIncio(fechaIncio);
        setMaxJugaoresPorEquipo(maxJugaoresPorEquipo);  // Representan la cantidad de maxima de jugadores que pueden haber por equipo
        setMinJugadoresPorEquipo(minJugadoresPorEquipo);  // Representan la cantidad de minima de jugadores que pueden haber por equipo
        validarIntegridadEdades();
    }

    public void validarIntegridadEdades(){
        if(minJugadoresPorEquipo >= maxJugaoresPorEquipo){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un nuevo TorneoEntity.";
            final String mensajeTecnico = "La cantidad máxima de jugadores debe ser mayor o igual a la cantidad mínima de jugadores de un equipo.";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
    }

    public boolean perteneceEquipoATorneo(EquipoEntity equipoEntity){
        boolean bandera = false;

        for (EquipoEntity eq: equipoEntityEntities) {
            if(eq.getNombre() == equipoEntity.getNombre()){
                bandera = true;
            }
        }

        return bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(getUtilText().applyTrim(nombre).length() < 3 ){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un nuevo TorneoEntity.";
            final String mensajeTecnico = "El nombre de un torneo debe tener 3 o más caracteres.";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DeporteEntity getDeporteEntity() {
        return deporteEntity;
    }

    public void setDeporteEntity(DeporteEntity deporteEntity) {
        if(getUtilObject().objetoEsNulo(deporteEntity)){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un nuevo TorneoEntity.";
            final String mensajeTecnico = "Un torneo obligatoriamente debe estar asociado a un DeporteEntity.";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.deporteEntity = deporteEntity;
    }

    public CategoriaEntity getCategoriaEntity() {
        return categoriaEntity;
    }

    public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
        if(getUtilObject().objetoEsNulo(categoriaEntity)){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un nuevo TorneoEntity.";
            final String mensajeTecnico = "Un torneo obligatoriamente debe estar asociado a una CategoriaEntity.";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.categoriaEntity = categoriaEntity;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        if(getUtilObject().objetoEsNulo(estado)){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un nuevo TorneoEntity.";
            final String mensajeTecnico = "Un torneo obligatoriamente debe estar asociado a un Estado De TorneoEntity.";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.estado = estado;
    }

    public GeneroEntity getGeneroEntity() {
        return generoEntity;
    }

    public void setGeneroEntity(GeneroEntity generoEntity) {
        if(getUtilObject().objetoEsNulo(generoEntity)){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un nuevo TorneoEntity.";
            final String mensajeTecnico = "Un torneo obligatoriamente debe estar asociado a un Genero.";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.generoEntity = generoEntity;
    }

    public Calendar getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(Calendar fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public int getMinJugadoresPorEquipo() {
        return minJugadoresPorEquipo;
    }

    public void setMinJugadoresPorEquipo(int minJugadoresPorEquipo) {
        if(minJugadoresPorEquipo < 1){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un nuevo TorneoEntity.";
            final String mensajeTecnico = "La cantidad Mínima de Jugadores no puede ser menor a 1";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.minJugadoresPorEquipo = minJugadoresPorEquipo;
    }

    public int getMaxJugaoresPorEquipo() {
        return maxJugaoresPorEquipo;
    }

    public void setMaxJugaoresPorEquipo(int maxJugaoresPorEquipo) {
        if(maxJugaoresPorEquipo < 1){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un nuevo TorneoEntity.";
            final String mensajeTecnico = "La cantidad Máxima de Jugadores no puede ser menor a 1.";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.maxJugaoresPorEquipo = maxJugaoresPorEquipo;
    }
}
