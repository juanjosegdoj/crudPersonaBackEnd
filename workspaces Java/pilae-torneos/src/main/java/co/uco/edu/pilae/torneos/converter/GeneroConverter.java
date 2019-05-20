package co.uco.edu.pilae.torneos.converter;

import co.uco.edu.pilae.torneos.entity.GeneroEntity;
import co.uco.edu.pilae.torneos.model.Genero;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class GeneroConverter {

    public GeneroEntity modelToEntity(Genero genero){

        GeneroEntity generoEntity;

        if(genero == null){
            generoEntity = null;
        }else{
            generoEntity = new GeneroEntity();

            generoEntity.setCodigo(genero.getCodigo());
            generoEntity.setNombre(genero.getNombre());
        }

        return generoEntity;
    }

    public Genero entityToModel(GeneroEntity generoEntity){
        Genero genero;
        if(generoEntity == null){
            genero = null;
        }else{
            genero = new Genero();

            genero.setCodigo(generoEntity.getCodigo());
            genero.setNombre(generoEntity.getNombre());
        }


        return genero;
    }

    public List<Genero> entityToModel(List<GeneroEntity> generosEntity){
        List<Genero> generoEntities = new ArrayList<Genero>(generosEntity.size());

        generosEntity.forEach((entity)->{
            generoEntities.add(entityToModel(entity));
        });

        return generoEntities;
    }

}
