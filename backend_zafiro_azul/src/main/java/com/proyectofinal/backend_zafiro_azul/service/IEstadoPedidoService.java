package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.EstadoPedido;

import java.util.List;

public interface IEstadoPedidoService {

    public List<EstadoPedido> getAllEstadoPedido();

    public void saveEstadoPedido(EstadoPedido estadoPedido);

    public void deleteEstadoPedido(Long idEstadoPedido);

    public EstadoPedido findEstadoPedido(Long idEstadoPedido);

    public void editEstadoPedido(Long idEstadoPedidoToUpdate, EstadoPedido estadoPedidoUpdated);
}
