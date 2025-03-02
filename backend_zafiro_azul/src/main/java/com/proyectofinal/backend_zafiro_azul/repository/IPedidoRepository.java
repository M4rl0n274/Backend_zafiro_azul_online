package com.proyectofinal.backend_zafiro_azul.repository;


import com.proyectofinal.backend_zafiro_azul.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Long> {

}
