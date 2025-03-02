package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.Producto;
import com.proyectofinal.backend_zafiro_azul.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        List<Producto> listProductos = productoRepository.findAll();
        return listProductos;
    }

    @Override
    public void createProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }

    @Override
    public Producto findProducto(Long idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public void updateProducto(Long idProductoToUpdate, Producto productoUpdated) {
        Producto productoToUpdate = productoRepository.findById(idProductoToUpdate).orElse(null);

        if(productoToUpdate != null){
            productoToUpdate.setNombreProducto(productoUpdated.getNombreProducto());
            productoToUpdate.setImagenProducto(productoUpdated.getImagenProducto());
            productoRepository.save(productoToUpdate);
        }
    }
}
