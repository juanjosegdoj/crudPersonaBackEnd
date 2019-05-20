package co.uco.edu.pilae.torneos.converter;

import co.uco.edu.pilae.torneos.entity.JugadorEntity;
import co.uco.edu.pilae.torneos.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JugadorConverter {

    @Autowired
    public GeneroConverter generoConverter;

    public Jugador entityToModel(JugadorEntity jugadorEntity){
        Jugador jugador;

        if(jugadorEntity == null){
            jugador = null;
        }else{
            jugador = new Jugador();

            jugador.setCodigo(jugadorEntity.getCodigo());
            jugador.setNombre(jugadorEntity.getNombre());
            jugador.setApellido(jugadorEntity.getApellido());
            jugador.setFechaNacimiento(jugadorEntity.getFechaNacimiento());
            jugador.setGenero(generoConverter.entityToModel(jugadorEntity.getGeneroEntity()));
        }

        return jugador;

    }
}
