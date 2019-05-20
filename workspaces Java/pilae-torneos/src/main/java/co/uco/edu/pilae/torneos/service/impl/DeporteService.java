package co.uco.edu.pilae.torneos.service.impl;

import co.uco.edu.pilae.torneos.converter.DeporteConverter;
import co.uco.edu.pilae.torneos.entity.DeporteEntity;
import co.uco.edu.pilae.torneos.model.Deporte;
import co.uco.edu.pilae.torneos.repository.DeporteRepository;
import co.uco.edu.pilae.torneos.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static co.uco.edu.pilae.torneos.utilitarios.objeto.UtilObject.getUtilObject;
import co.uco.edu.pilae.torneos.utilitarios.excepcion.excepcion.AplicacionExcepcion;

@Service
public class DeporteService implements IDeporteService {

    @Autowired
    private DeporteRepository deporteRepository;

    @Autowired
    private DeporteConverter deporteConverter;

    public List<Deporte> listAll(){
        return deporteConverter.entityToModel(deporteRepository.findAll());
    };

    public void save(Deporte deporte) {

        DeporteEntity optDeporteEntity = deporteRepository.findByName(deporte.getNombre());

        if(getUtilObject().objetoEsNulo(optDeporteEntity)
        ){
            deporteRepository.save(deporteConverter.modelToEntity(deporte));
        }else{
            throw AplicacionExcepcion.CREAR("No es posible ingresar 2 deportes con el mismo nombre.");
        }
    }

    public co.uco.edu.pilae.torneos.model.Deporte findById(long id) {
        return deporteConverter.entityToModel(deporteRepository.findById(id).orElse(null));
    }
}
