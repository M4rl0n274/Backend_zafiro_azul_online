package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.exception.*;
import com.proyectofinal.backend_zafiro_azul.model.CategoriaProducto;
import com.proyectofinal.backend_zafiro_azul.repository.ICategoriaProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaProductoService implements ICategoriaProductoService{

    @Autowired
    private ICategoriaProductoRepository categoriaProductoRepository;

    @Override
    public List<CategoriaProducto> getAllCategoriaProducto() {
        boolean listaCategoriaVacia = categoriaProductoRepository.findAll().isEmpty();
        if(listaCategoriaVacia){
            return new ArrayList<>();
        }
        return categoriaProductoRepository.findAll();
    }

    @Transactional
    @Override
    public void saveCategoriaProducto(CategoriaProducto categoriaProducto) throws EntityConflictException{
        boolean nombreDuplicado = categoriaProductoRepository.existsByNombreCategoriaAndIdCategoriaNot(
                categoriaProducto.getNombreCategoria(), categoriaProducto.getIdCategoria());
        if(nombreDuplicado)
            throw new EntityConflictException("Categoría de producto", "nombre", categoriaProducto.getNombreCategoria());

        categoriaProductoRepository.save(categoriaProducto);
    }

    @Transactional
    @Override
    public void deleteCategoriaProducto(Long id_categoria) throws CategoriaProductoNotFoundException{
        if(!categoriaProductoRepository.existsById(id_categoria)){
            throw new CategoriaProductoNotFoundException(id_categoria);
        }
        categoriaProductoRepository.deleteById(id_categoria);
    }

    @Override
    public CategoriaProducto findCategoriaProducto(Long id_categoria) throws CategoriaProductoNotFoundException {
        return categoriaProductoRepository.findById(id_categoria).orElseThrow(()->new
                CategoriaProductoNotFoundException(id_categoria));
    }

    @Transactional
    @Override
    public void editCategoriaProducto(Long idCategoriaToUpdate, CategoriaProducto categoriaUpdated)
            throws CategoriaProductoNotFoundException, EntityConflictException, NoChangesMadeException{
        CategoriaProducto categoriaExistente = categoriaProductoRepository.findById(idCategoriaToUpdate).orElseThrow(()->
                new CategoriaProductoNotFoundException(idCategoriaToUpdate));

        //Verificar si existe nombre de categoría duplicado.
        boolean nombreDuplicado = categoriaProductoRepository.existsByNombreCategoriaAndIdCategoriaNot(
                categoriaUpdated.getNombreCategoria(), idCategoriaToUpdate);
        if(nombreDuplicado){
            throw new EntityConflictException("Categoría de producto", "nombre", categoriaUpdated.getNombreCategoria());
        }

        if (categoriaExistente.getNombreCategoria().equals(categoriaUpdated.getNombreCategoria()) &&
                categoriaExistente.getDescripcionCategoria().equals(categoriaUpdated.getDescripcionCategoria())) {
            throw new NoChangesMadeException();
        }

        categoriaExistente.setNombreCategoria(categoriaUpdated.getNombreCategoria());
        categoriaExistente.setDescripcionCategoria(categoriaUpdated.getDescripcionCategoria());

        categoriaProductoRepository.save(categoriaExistente);
    }
}
