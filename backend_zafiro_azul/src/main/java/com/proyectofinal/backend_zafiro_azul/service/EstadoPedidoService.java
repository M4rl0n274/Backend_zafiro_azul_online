package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.exception.*;
import com.proyectofinal.backend_zafiro_azul.model.EstadoPedido;
import com.proyectofinal.backend_zafiro_azul.repository.IEstadoPedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoPedidoService implements IEstadoPedidoService{

    @Autowired
    private IEstadoPedidoRepository estadoPedidoRepository;

    @Override
    public List<EstadoPedido> getAllEstadoPedido() {
        boolean listEsadosVacia = estadoPedidoRepository.findAll().isEmpty();
        if(listEsadosVacia){
            return new ArrayList<>();
        }
        return estadoPedidoRepository.findAll();
    }

    @Transactional
    @Override
    public void saveEstadoPedido(EstadoPedido estadoPedido) throws EntityConflictException{
        boolean nombreDuplicado = estadoPedidoRepository.existsByNombreEstadoAndIdEstadoNot(
                estadoPedido.getNombreEstado(), estadoPedido.getIdEstado());
        if(nombreDuplicado){
            throw new EntityConflictException("Categoría de producto", "nombre", estadoPedido.getNombreEstado());
        }

        estadoPedidoRepository.save(estadoPedido);
    }

    @Transactional
    @Override
    public void deleteEstadoPedido(Long idEstadoPedido) throws EstadoPedidoNotFoundException{
        if(!estadoPedidoRepository.existsById(idEstadoPedido)){
            throw new EstadoPedidoNotFoundException(idEstadoPedido);
        }
        estadoPedidoRepository.deleteById(idEstadoPedido);
    }

    @Override
    public EstadoPedido findEstadoPedido(Long idEstadoPedido) throws EstadoPedidoNotFoundException{
        if(!estadoPedidoRepository.existsById(idEstadoPedido)){
            throw new EstadoPedidoNotFoundException(idEstadoPedido);
        }
        return estadoPedidoRepository.findById(idEstadoPedido).orElse(null);
    }

    @Transactional
    @Override
    public void editEstadoPedido(Long idEstadoPedidoToUpdate, EstadoPedido estadoPedidoUpdated)
    throws EstadoPedidoNotFoundException, EntityConflictException, NoChangesMadeException{
        EstadoPedido estadoExistente = estadoPedidoRepository.findById(idEstadoPedidoToUpdate).orElseThrow(()->
                new EstadoPedidoNotFoundException(idEstadoPedidoToUpdate));

        boolean nombreDuplicado = estadoPedidoRepository.existsByNombreEstadoAndIdEstadoNot(estadoPedidoUpdated.getNombreEstado(),
                idEstadoPedidoToUpdate);
            if(nombreDuplicado){
                throw new EntityConflictException("estado pedido", "nombre", estadoPedidoUpdated.getNombreEstado());
            }
            if(estadoExistente.getNombreEstado().equals(estadoPedidoUpdated.getNombreEstado())){
                throw new NoChangesMadeException();
            }

        estadoExistente.setNombreEstado(estadoPedidoUpdated.getNombreEstado());

        estadoPedidoRepository.save(estadoExistente);
    }
}
