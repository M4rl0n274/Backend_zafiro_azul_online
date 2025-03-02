package com.proyectofinal.backend_zafiro_azul.repository;

import com.proyectofinal.backend_zafiro_azul.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}
