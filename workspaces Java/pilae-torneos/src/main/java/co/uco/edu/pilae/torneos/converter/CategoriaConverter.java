package co.uco.edu.pilae.torneos.converter;

import co.uco.edu.pilae.torneos.entity.CategoriaEntity;
import co.uco.edu.pilae.torneos.model.Categoria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaConverter {

    public CategoriaEntity modelToEntity(Categoria categoria){
        CategoriaEntity categoriaEntity;

        if(categoria == null){
            categoriaEntity = null;
        }else {
            categoriaEntity = new CategoriaEntity();

            categoriaEntity.setCodigo(categoria.getCodigo());
            categoriaEntity.setNombre(categoria.getNombre());
            categoriaEntity.setDescripcion(categoria.getDescripcion());
            categoriaEntity.setFechaMaxima(categoria.getFechaMaxima());
            categoriaEntity.setFechaMinima(categoria.getFechaMinima());
        }
        return categoriaEntity;
    }

    public Categoria entityToModel(CategoriaEntity categoriaEntity){
        Categoria categoria;

        if(categoriaEntity == null){
            categoria = null;
        }else {
            categoria = new Categoria();

            categoria.setCodigo(categoriaEntity.getCodigo());
            categoria.setNombre(categoriaEntity.getNombre());
            categoria.setDescripcion(categoriaEntity.getDescripcion());
            categoria.setFechaMinima(categoriaEntity.getFechaMinima());
            categoria.setFechaMaxima(categoriaEntity.getFechaMaxima());
        }

        return categoria;

    }

    public List<Categoria> entityToModel(List<CategoriaEntity> categoriasEntity){
        List<Categoria> categorias = new ArrayList<Categoria>(categoriasEntity.size());

        categoriasEntity.forEach((entity)->{
            categorias.add(entityToModel(entity));
        });
        return categorias;
    }

    public List<CategoriaEntity> modelToEntity(List<Categoria> categorias){

        List<CategoriaEntity> categoriasEntity = new ArrayList<CategoriaEntity>(categorias.size());

        categorias.forEach((model)->{
            categoriasEntity.add(modelToEntity(model));
        });

        return categoriasEntity;

    }
}
