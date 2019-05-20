package co.uco.edu.pilae.torneos.model;

import co.uco.edu.pilae.torneos.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import co.uco.edu.pilae.torneos.utilitarios.excepcion.excepcion.AplicacionExcepcion;
import lombok.Data;

import java.util.Calendar;

import static co.uco.edu.pilae.torneos.utilitarios.cadenas.UtilText.getUtilText;
import static co.uco.edu.pilae.torneos.utilitarios.objeto.UtilObject.getUtilObject;

@Data
public class Jugador {

    private Long codigo;
    private String nombre;
    private String apellido;
    private Genero genero;
    private Calendar fechaNacimiento;


    public Jugador() {
        super();
    }

    public Jugador(Long codigo, String nombre, String apellido, Genero genero, Calendar fechaNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
        if(codigo < 1){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un JugadorEntity";
            final String mensajeTecnico = "El codigo del JugadorEntity debe ser mayor a cero";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(getUtilText().applyTrim(nombre).length() < 3 ){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un JugadorEntity.";
            final String mensajeTecnico = "El nombre del jugador debe tener como mínimo 3 caracteres.";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        if(getUtilText().applyTrim(apellido).length() < 3 ){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un JugadorEntity.";
            final String mensajeTecnico = "El apellidp del jugador debe tener como mínimo 3 caracteres.";

            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        if(getUtilObject().objetoEsNulo(genero)){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un JugadorEntity.";
            final String mensajeTecnico = "El JugadorEntity debe tener un género definido.";
            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.genero = genero;
    }

    public Calendar getFechaNacimiento() {

        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        if(!fechaNacimiento.before(Calendar.getInstance())){
            final String mensajeUsuario = "Se ha presentado un problema tratando de crear un JugadorEntity.";
            final String mensajeTecnico = "La fecha de nacimiento de un jugador no puede sobrepasar la fecha actual";
            throw AplicacionExcepcion.CREAR(mensajeTecnico, mensajeUsuario, ExcepcionEnum.DOMINIO);
        }
        this.fechaNacimiento = fechaNacimiento;
    }
}
