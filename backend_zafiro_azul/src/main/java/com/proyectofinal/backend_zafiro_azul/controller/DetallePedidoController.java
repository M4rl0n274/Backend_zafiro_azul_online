package com.proyectofinal.backend_zafiro_azul.controller;

import com.proyectofinal.backend_zafiro_azul.model.DetallePedido;
import com.proyectofinal.backend_zafiro_azul.service.IDetallePedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_pedido")
public class DetallePedidoController {
    @Autowired
    private IDetallePedidoService detallePedidoService;

    @GetMapping("/traer")
    public List<DetallePedido> getCategorias(){
        return detallePedidoService.getAllDetallPedido();
    }

    @PostMapping("/crear")
    public ResponseEntity<String> saveDetalle(@Valid @RequestBody DetallePedido detallePedido){
        detallePedidoService.saveDetallePedido(detallePedido);
        return ResponseEntity.ok("{\"message\": \"Detalle pedido creado exitosamente.\"}");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteDetalle(@PathVariable Long id){
        detallePedidoService.deleteDetallePedido(id);
        return ResponseEntity.ok("{\"message\": \"Detalle pedido borrado exitosamente.\"}");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editCategoria(@PathVariable Long id,
                                                @Valid @RequestBody DetallePedido detallePedido){
        detallePedidoService.editDetallePedido(id, detallePedido);
        return ResponseEntity.ok("{\"message\": \"Detalle Pedido editado exitosamente.\"}");
    }
}
