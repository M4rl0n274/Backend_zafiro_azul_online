package com.proyectofinal.backend_zafiro_azul.controller;

import com.proyectofinal.backend_zafiro_azul.model.CategoriaProducto;
import com.proyectofinal.backend_zafiro_azul.service.ICategoriaProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categorias")
@RestController
public class CategoriaProductoController {

    @Autowired
    private ICategoriaProductoService categoriaProductoService;

    @GetMapping("/traer")
    public List<CategoriaProducto> getCategorias(){
        return categoriaProductoService.getAllCategoriaProducto();
    }

    @PostMapping("/crear")
    public ResponseEntity<?> saveCategoria(@Valid @RequestBody CategoriaProducto categoriaProducto) {
        categoriaProductoService.saveCategoriaProducto(categoriaProducto);
        return ResponseEntity.ok("{\"message\": \"Categoría creada exitosamente.\"}");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id){
        categoriaProductoService.deleteCategoriaProducto(id);
        return ResponseEntity.ok("{\"message\": \"Categoría eliminada exitosamente.\"}");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editCategoria(@PathVariable Long id, @Valid @RequestBody CategoriaProducto categoriaUpdated) {
        categoriaProductoService.editCategoriaProducto(id, categoriaUpdated);
        return ResponseEntity.ok("{\"message\": \"Categoría actualizada exitosamente.\"}");
    }
}
