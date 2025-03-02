package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.Pedido;

import java.util.List;

public interface IPedidoService {

    List<Pedido> getAllPedidos();

    void createPedido(Pedido pedido);

    void deletePedido(Long idPedido);

    Pedido findPedido(Long idPedido);

    void updatePedido(Long idPedidoToUpdate, Pedido pedidoUpdated);

    void validarPedido(Pedido pedido);
}
