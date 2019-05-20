
package co.uco.edu.pilae.torneos.utilitarios.estado.enumeracion;

public enum EstadoEnum {

    ENINSCRIPCION,   // Momento del torneo, en cual se está creando el torneo."),
    ENJUEGO,        // Momento del torneo en el que se tiene un fixture y partido jugados o sin jugar"),
    CANCELADO,      // TorneoEntity que no se continuó jugando y que por ende no llegó a la etapa final"),
    FINALIZADO;     //TorneoEntity que ya ha pasado por todas las etapas y que ya cuenta con campeones.");

}
