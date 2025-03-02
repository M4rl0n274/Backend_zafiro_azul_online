package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> getAllProductos();

    void createProducto(Producto producto);

    void deleteProducto(Long idProducto);

    Producto findProducto(Long idProducto);

    void updateProducto(Long idProductoToUpdate, Producto productoUpdated);
}
