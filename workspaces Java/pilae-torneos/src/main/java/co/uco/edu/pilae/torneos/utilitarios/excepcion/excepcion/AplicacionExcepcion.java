package co.uco.edu.pilae.torneos.utilitarios.excepcion.excepcion;

import co.uco.edu.pilae.torneos.utilitarios.excepcion.enumeracion.ExcepcionEnum;
import static co.uco.edu.pilae.torneos.utilitarios.objeto.UtilObject.getUtilObject;
import static co.uco.edu.pilae.torneos.utilitarios.cadenas.UtilText.getUtilText;


public final class AplicacionExcepcion extends RuntimeException {

    /**
     * Serial Version por defecto de la clase
     */
    private static final long serialVersionUID = 1L;

    private String mensajeTecnico;
    private String mensajeUsuario;
    private Exception excepcionRaiz;
    private boolean existeExcepcioneRaiz;
    private ExcepcionEnum lugarExcepcion;

    private AplicacionExcepcion(final String mensajeTecnico, final String mensajeUsuario, final Exception excepcionRaiz,
                                final ExcepcionEnum lugarExcepcion) {
        super();
        setMensajeTecnico(mensajeTecnico);
        setMensajeUsuario(mensajeUsuario);
        setExcepcionRaiz(excepcionRaiz);
        setLugarExcepcion(lugarExcepcion);
    }

    public static AplicacionExcepcion CREAR(final String mensajeTecnico,
                                            final String mensajeUsuario,
                                            final Exception excepcionRaiz,
                                            final ExcepcionEnum lugarExcepcion) {
        return new AplicacionExcepcion(mensajeTecnico, mensajeUsuario, excepcionRaiz, lugarExcepcion);
    }

    public static AplicacionExcepcion CREAR(final String mensajeUsuario,
                                            final Exception excepcionRaiz,
                                            final ExcepcionEnum lugarExcepcion) {
        return new AplicacionExcepcion(mensajeUsuario, mensajeUsuario, excepcionRaiz, lugarExcepcion);
    }

    public static AplicacionExcepcion CREAR(final String mensajeTecnico,
                                            final String mensajeUsuario,
                                            final ExcepcionEnum lugarExcepcion) {
        return new AplicacionExcepcion(mensajeTecnico, mensajeUsuario, null, lugarExcepcion);
    }

    public static AplicacionExcepcion CREAR(final String mensajeUsuario, final ExcepcionEnum lugarExcepcion) {
        return new AplicacionExcepcion(mensajeUsuario, mensajeUsuario, null, lugarExcepcion);
    }

    public static AplicacionExcepcion CREAR(final String mensajeUsuario) {
        return new AplicacionExcepcion(mensajeUsuario, mensajeUsuario, null, null);
    }

    private final void setMensajeTecnico(String mensajeTecnico) {
        this.mensajeTecnico = getUtilText().applyTrim(mensajeTecnico);
    }
    private final void setMensajeUsuario(String mensajeUsuario) {
        this.mensajeUsuario = getUtilText().applyTrim(mensajeUsuario);
    }
    private final void setExcepcionRaiz(Exception excepcionRaiz) {
        setExisteExcepcioneRaiz(!getUtilObject().objetoEsNulo(excepcionRaiz));
        this.excepcionRaiz = getUtilObject().getDefectValue(excepcionRaiz, new Exception());
    }
    private final void setExisteExcepcioneRaiz(boolean existeExcepcioneRaiz) {
        this.existeExcepcioneRaiz = existeExcepcioneRaiz;
    }
    private final void setLugarExcepcion(ExcepcionEnum lugarExcepcion) {
        this.lugarExcepcion = getUtilObject().getDefectValue(lugarExcepcion, ExcepcionEnum.GENERAL);
    }

    public final String getMensajeTecnico() {
        return mensajeTecnico;
    }
    public final String getMensajeUsuario() {
        return mensajeUsuario;
    }
    public final Exception getExcepcionRaiz() {
        return excepcionRaiz;
    }
    public final boolean isExisteExcepcioneRaiz() {
        return existeExcepcioneRaiz;
    }
    public final ExcepcionEnum getLugarExcepcion() {
        return lugarExcepcion;
    }
}