package com.proyectofinal.backend_zafiro_azul.service;


import com.proyectofinal.backend_zafiro_azul.model.VarianteProducto;

import java.util.List;

public interface IvarianteProductoService {

    //obtener todas las variantes
    public List<VarianteProducto> getAllVariantes();

    //obtener por ID
    public VarianteProducto getVarianteById(Long id);

    //crear variante
    public void createVariant(VarianteProducto varianteProducto);

    // actualizar variante
    public void updateVariant(long id, VarianteProducto varianteDetails);

    // eliminar
    public void deleteVariant(Long id);



}
