package co.uco.edu.pilae.torneos.utilitarios.fecha;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class UtilDate {

    private static final UtilDate INSTANCE = new UtilDate();

    private UtilDate() {
        super();
    }

    public static final UtilDate getUtilText() {
        return INSTANCE;
    }

    public String toString(Calendar fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(fecha.getTime());
    }

    public boolean areEquals(Calendar fecha1, Calendar fecha2){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return (sdf.format(fecha1.getTime()).equals(sdf.format(fecha2.getTime())));
    }

}
