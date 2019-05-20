package co.uco.edu.pilae.torneos.utilitarios.excepcion.enumeracion;

import lombok.Data;

public enum ExcepcionEnum {

    DATOS("DATOS", "Excepcion presentada en la capa de datos"),
    NEGOCIO("NEGOCIO", "Excepcion presentada en la capa de negocio"),
    API("API", "Excepcion presentada en la capa de servicios"),
    DOMINIO("DOMINIO", "Excepcion presentada en la capa de entity"),
    GENERAL("GENERAL", "Excepcion presentada a nivel General");

    private String codigo;
    private String nombre;

    private ExcepcionEnum(final String codigo, final String nombre) {
        setCodigo(codigo);
        setNombre(nombre);
    }

    public final String getCodigo() {
        return codigo;
    }

    private final void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public final String getNombre() {
        return nombre;
    }

    private final void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
