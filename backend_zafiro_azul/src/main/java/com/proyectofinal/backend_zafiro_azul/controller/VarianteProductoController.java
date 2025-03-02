package com.proyectofinal.backend_zafiro_azul.controller;

import com.proyectofinal.backend_zafiro_azul.model.VarianteProducto;
import com.proyectofinal.backend_zafiro_azul.service.IvarianteProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VarianteProductoController {

    @Autowired
    private IvarianteProductoService ivarianteProductoServ;

    @GetMapping ("/varianteproducto/traer")
    public List<VarianteProducto> getAllVariantes(){
        return ivarianteProductoServ.getAllVariantes();
    }

    @GetMapping ("/varianteproducto/traer_id/{id}")
    public VarianteProducto getVarianteById(@PathVariable Long id){
        return ivarianteProductoServ.getVarianteById(id);
    }

    @PostMapping ("/varianteproducto/crear")
    public String createVariant(@RequestBody VarianteProducto varianteProducto){
        ivarianteProductoServ.createVariant(varianteProducto);
        return "Variante creada con exito";
    }

    @PutMapping ("/varianteproducto/editar/{id}")
    public ResponseEntity<String>updateVariant (
            @PathVariable Long id,
            @RequestBody VarianteProducto varianteProducto){
        ivarianteProductoServ.updateVariant(id, varianteProducto);
        return ResponseEntity.ok("Se actualizo la variante del prodcuto");
    }

    @DeleteMapping ("/varianteproducto/borrar/{id}")
    public String deleteVariant(@PathVariable Long id){
        ivarianteProductoServ.deleteVariant(id);
        return "La variante del producto ha sido eliminada";
    }
}
