package co.uco.edu.pilae.torneos.service.impl;

import co.uco.edu.pilae.torneos.converter.CategoriaConverter;
import co.uco.edu.pilae.torneos.entity.CategoriaEntity;
import co.uco.edu.pilae.torneos.model.Categoria;
import co.uco.edu.pilae.torneos.repository.CategoriaRepository;
import co.uco.edu.pilae.torneos.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static co.uco.edu.pilae.torneos.utilitarios.objeto.UtilObject.getUtilObject;
import co.uco.edu.pilae.torneos.utilitarios.excepcion.excepcion.AplicacionExcepcion;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaConverter categoriaConverter;


    @Override
    public Categoria findByName(String name){
        return categoriaConverter.entityToModel(categoriaRepository.findByName(name));
    }

    @Override
    public void save(Categoria categoria) {

        CategoriaEntity categoriaEntity = categoriaRepository.findByName(categoria.getNombre());

        if(getUtilObject().objetoEsNulo(categoriaEntity)){
            categoriaRepository.save(categoriaConverter.modelToEntity(categoria));
        }else{
            throw AplicacionExcepcion.CREAR("No es posible ingresar 2 categorias con el mismo nombre.");
        }
    }

    @Override
    public List<Categoria> listAll() {

        return categoriaConverter.entityToModel(categoriaRepository.findAll());
    }

    @Override
    public Categoria findById(long id) {
        return categoriaConverter.entityToModel(categoriaRepository.findById(id).orElse(null));

    }
}
