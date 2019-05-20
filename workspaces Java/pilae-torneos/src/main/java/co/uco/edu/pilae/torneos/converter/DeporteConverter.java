package co.uco.edu.pilae.torneos.converter;

import co.uco.edu.pilae.torneos.entity.DeporteEntity;
import co.uco.edu.pilae.torneos.model.Deporte;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static co.uco.edu.pilae.torneos.utilitarios.cadenas.UtilText.getUtilText;


@Component
public class DeporteConverter {

    public DeporteEntity modelToEntity(Deporte deporte){

        DeporteEntity deporteEntity;

        if(deporte == null){
            deporteEntity = null;
        }else{
            deporteEntity = new DeporteEntity();

            deporteEntity.setCodigo(deporte.getCodigo());
            deporteEntity.setNombre(getUtilText().applyTrim(deporte.getNombre()));
            deporteEntity.setDescripcion(getUtilText().applyTrim(deporte.getDescripcion()));
        }

        return deporteEntity;
    }

    public Deporte entityToModel(DeporteEntity deporteEntity){
        Deporte deporte;

        if(deporteEntity == null){
            deporte = null;
        }else{
            deporte = new Deporte();

            deporte.setCodigo(deporteEntity.getCodigo());
            deporte.setNombre(deporteEntity.getNombre());
            deporte.setDescripcion(deporteEntity.getDescripcion());
        }

        return deporte;
    }

    public List<Deporte> entityToModel(List<DeporteEntity> deportesEntity){
        List<co.uco.edu.pilae.torneos.model.Deporte> deportes = new ArrayList<co.uco.edu.pilae.torneos.model.Deporte>(deportesEntity.size());

        deportesEntity.forEach((model) -> {
            deportes.add(entityToModel(model));
        });

        return deportes;
    }

    public List<DeporteEntity> modelToEntity(List<Deporte> deportes){
        List<DeporteEntity> deportesEntity = new ArrayList<DeporteEntity>(deportes.size());

        deportes.forEach((entity)-> {
            deportesEntity.add(modelToEntity(entity));
        });

        return deportesEntity;
    }
}

/**
 * Motivación para usar DTO, me permite recibir el objeto sin necesidad de hacer validaciones
 * dejandolo como objeto de Java, posteriormente se pueden hacer validaciones asegurando sin la necesidad
 * de usar validators de JPA pues se pasará por los filtros correspondientes.
 */
