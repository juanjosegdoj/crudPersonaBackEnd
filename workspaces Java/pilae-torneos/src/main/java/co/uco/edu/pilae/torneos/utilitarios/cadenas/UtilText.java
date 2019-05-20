package co.uco.edu.pilae.torneos.utilitarios.cadenas;

import static co.uco.edu.pilae.torneos.utilitarios.objeto.UtilObject.getUtilObject;
public final class UtilText {

    private static final UtilText INSTANCE = new UtilText();

    private UtilText() {
        super();
    }

    public static final UtilText getUtilText() {
        return INSTANCE;
    }

    public String applyTrim(String cadena) {
        return getUtilObject().getDefectValue(cadena, "").trim();
    }

    public final boolean isEmptyOrNull(final String cadena) {
        return applyTrim(cadena).intern() == "" ;
    }

}
