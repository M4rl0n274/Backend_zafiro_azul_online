package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.exception.DetallePedidoNotFoundException;
import com.proyectofinal.backend_zafiro_azul.exception.EntityConflictException;
import com.proyectofinal.backend_zafiro_azul.exception.PedidoNotFoundException;
import com.proyectofinal.backend_zafiro_azul.model.Pedido;
import com.proyectofinal.backend_zafiro_azul.repository.IPedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAllPedidos() {
        boolean listaPedidosVacia = pedidoRepository.findAll().isEmpty();
        if(listaPedidosVacia){
            return new ArrayList<>();
        }
        return pedidoRepository.findAll();
    }

    @Transactional
    @Override
    public void createPedido(Pedido pedido) {
        validarPedido(pedido);
        pedidoRepository.save(pedido);
    }

    @Override
    public void deletePedido(Long idPedido) {
        pedidoRepository.deleteById(idPedido);
    }

    @Override
    public Pedido findPedido(Long idPedido) throws PedidoNotFoundException {
        return pedidoRepository.findById(idPedido).orElseThrow(()-> new PedidoNotFoundException(idPedido));
    }

    @Override
    public void updatePedido(Long idPedidoToUpdate, Pedido pedidoUpdated) throws PedidoNotFoundException{
        Pedido pedidoToUpdate = pedidoRepository.findById(idPedidoToUpdate).orElseThrow(()->
                new PedidoNotFoundException(idPedidoToUpdate));

        pedidoToUpdate.setFechaPedido(pedidoUpdated.getFechaPedido());
        pedidoToUpdate.setTotalPedido(pedidoUpdated.getTotalPedido());
        pedidoRepository.save(pedidoToUpdate);
    }

    @Override
    public void validarPedido(Pedido pedido) {
        if(pedido.getUsuario() != null && pedido.getUsuarioTemp() != null){
            throw new IllegalArgumentException("El pedido no puede tener un usuario registrado y un usuario temporal al mismo tiempo.");
        }
        if(pedido.getUsuario() == null && pedido.getUsuarioTemp() == null){
            throw new IllegalArgumentException("El pedido debe tener un usuario registrado o un usuario temporal.");
        }
    }
}
