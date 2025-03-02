package com.proyectofinal.backend_zafiro_azul.repository;

import com.proyectofinal.backend_zafiro_azul.model.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoPedidoRepository extends JpaRepository<EstadoPedido, Long> {
    boolean existsByNombreEstadoAndIdEstadoNot(String nombreEstado, Long id);
}
