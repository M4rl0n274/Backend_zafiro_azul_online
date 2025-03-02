package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.DetallePedido;

import java.util.List;

public interface IDetallePedidoService {

    public List<DetallePedido> getAllDetallPedido();

    public void saveDetallePedido(DetallePedido detallePedido);

    public void deleteDetallePedido(Long idDetallePedido);

    public DetallePedido findDetallePedido(Long idDetallePedido);

    public void editDetallePedido(Long idDetallePedidoToUpdate, DetallePedido detallePedidoUpdated);
}
