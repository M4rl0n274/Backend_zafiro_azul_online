package com.proyectofinal.backend_zafiro_azul.controller;

import com.proyectofinal.backend_zafiro_azul.model.Pedido;
import com.proyectofinal.backend_zafiro_azul.service.IPedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    //Endpoint para obtener todos los pedidos
    @GetMapping("/traer")
    public List<Pedido> getPedido(){
        return pedidoService.getAllPedidos();
    }

    //Endpoint para obtener un pedido por id
    @GetMapping("/traer/{id}")
    public ResponseEntity<?> findPedido(@PathVariable Long id){
        Pedido pedido = pedidoService.findPedido(id);
        return ResponseEntity.ok("{\"message\": \"Pedidos traídos exitosamente.\"}");
    }

    //Endpoint para crear un pedido
    @PostMapping("/crear")
    public ResponseEntity<?> createPedido(@Valid @RequestBody Pedido pedido){
        pedidoService.createPedido(pedido);
        return ResponseEntity.ok("{\"message\": \"Pedido creado exitosamente.\"}");
    }

    //Endpoint para borrar un pedido
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Long id){
        pedidoService.deletePedido(id);
        return ResponseEntity.ok("{\"message\": \"Pedido borrado exitosamente.\"}");
    }

    //Endpoint para modificar un pedido
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> updatePedido(
            @PathVariable Long id,
            @Valid @RequestBody Pedido pedidoUpdated
    ){
        pedidoService.updatePedido(id, pedidoUpdated);
        return ResponseEntity.ok("{\"message\": \"Pedido editado exitosamente.\"}");
    }


}
