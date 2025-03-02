package com.proyectofinal.backend_zafiro_azul.controller;

import com.proyectofinal.backend_zafiro_azul.model.CategoriaProducto;
import com.proyectofinal.backend_zafiro_azul.model.EstadoPedido;
import com.proyectofinal.backend_zafiro_azul.service.ICategoriaProductoService;
import com.proyectofinal.backend_zafiro_azul.service.IEstadoPedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado_pedido")
public class EstadoPedidoController {

    @Autowired
    private IEstadoPedidoService estadoPedidoService;

    @GetMapping("/traer")
    public List<EstadoPedido> getEstados(){
        return estadoPedidoService.getAllEstadoPedido();
    }

    @PostMapping("/crear")
    public ResponseEntity<String> saveCategoria(@Valid @RequestBody EstadoPedido estadoPedido){
        estadoPedidoService.saveEstadoPedido(estadoPedido);
        return ResponseEntity.ok("{\"message\": \"Estado pedido creado exitosamente.\"}");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteEstado(@PathVariable Long id){
        estadoPedidoService.deleteEstadoPedido(id);
        return ResponseEntity.ok("{\"message\": \"Estado pedido eliminado exitosamente.\"}");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editEstado(@PathVariable Long id,
                                                @Valid @RequestBody EstadoPedido estadoPedidoUpdated){
        estadoPedidoService.editEstadoPedido(id, estadoPedidoUpdated);
        return ResponseEntity.ok("{\"message\": \"Estado pedido editado exitosamente.\"}");
    }
}
