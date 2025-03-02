package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.CategoriaProducto;

import java.util.List;

public interface ICategoriaProductoService {

    public List<CategoriaProducto> getAllCategoriaProducto();

    public void saveCategoriaProducto(CategoriaProducto categoriaProducto);

    public void deleteCategoriaProducto(Long id_categoria);

    public CategoriaProducto findCategoriaProducto(Long id_categoria);

    public void editCategoriaProducto(Long idCategoriaToUpdate, CategoriaProducto categoriaUpdated);
}
