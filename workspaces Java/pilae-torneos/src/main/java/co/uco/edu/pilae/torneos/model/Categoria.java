package co.uco.edu.pilae.torneos.model;

import lombok.Data;

import java.util.Calendar;

@Data
public class Categoria {

    private Long codigo;
    private String nombre;
    private String descripcion;
    private Calendar fechaMinima;  // Indica la menor edad permitida
    private Calendar fechaMaxima;  // Indica la mayor edad perimitida

}
