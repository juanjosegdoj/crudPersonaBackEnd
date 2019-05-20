package co.uco.edu.pilae.torneos.utilitarios.objeto;

public final class UtilObject {

    private static final UtilObject INSTANCE = new UtilObject();

    private UtilObject() {
        super();
    }

    public static final UtilObject getUtilObject() {
        return INSTANCE;
    }

    public <T> T getDefectValue(T object, T defectValue) {
        T retorno = object;

        if(object == null) {
            retorno = defectValue;
        }

        return retorno;
    }

    public <T> boolean objetoEsNulo(T objeto) {
        return (objeto == null);
    }
}

