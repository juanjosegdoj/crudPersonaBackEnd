package co.com.pilae.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TorneoDominio {

    private String nombre;
    private String descripcion;
    private DeporteDominio deporte;
    private CategoriaDominio categoria;
    private EstadoDominio estado;
    private GeneroDominio genero;
    private List<EquipoDominio> equipos = new ArrayList<>();

}
