package com.proyectofinal.backend_zafiro_azul.repository;

import com.proyectofinal.backend_zafiro_azul.model.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaProductoRepository extends JpaRepository<CategoriaProducto, Long> {
    boolean existsByNombreCategoriaAndIdCategoriaNot(String nombreCategoria, Long idCategoria);
}
