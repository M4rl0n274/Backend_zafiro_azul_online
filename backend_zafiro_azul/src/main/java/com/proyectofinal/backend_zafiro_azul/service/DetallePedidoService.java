package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.exception.DetallePedidoNotFoundException;
import com.proyectofinal.backend_zafiro_azul.exception.MonetaryCalculationException;
import com.proyectofinal.backend_zafiro_azul.model.DetallePedido;
import com.proyectofinal.backend_zafiro_azul.repository.IDetallePedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetallePedidoService implements IDetallePedidoService{

    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedido> getAllDetallPedido() {
        boolean listaDetallePedidoVacia = detallePedidoRepository.findAll().isEmpty();
        if(listaDetallePedidoVacia){
            return new ArrayList<>();
        }
        return detallePedidoRepository.findAll();
    }

    @Transactional
    @Override
    public void saveDetallePedido(DetallePedido detallePedido) throws MonetaryCalculationException{
        if (validarSubtotal(detallePedido)) {
            throw new MonetaryCalculationException(
                    "Subtotal",
                    "Detalle pedido",
                    calcularSubtotal(detallePedido));
        }
        detallePedidoRepository.save(detallePedido);
    }

    @Transactional
    @Override
    public void deleteDetallePedido(Long idDetallePedido) throws DetallePedidoNotFoundException{
        if(!detallePedidoRepository.existsById(idDetallePedido)){
            throw new DetallePedidoNotFoundException(idDetallePedido);
        }
        detallePedidoRepository.deleteById(idDetallePedido);
    }

    @Override
    public DetallePedido findDetallePedido(Long idDetallePedido) throws DetallePedidoNotFoundException{
        if(!detallePedidoRepository.existsById(idDetallePedido)){
            throw new DetallePedidoNotFoundException(idDetallePedido);
        }
        return detallePedidoRepository.findById(idDetallePedido).orElseThrow(()->new
                DetallePedidoNotFoundException(idDetallePedido));
    }

    @Transactional
    @Override
    public void editDetallePedido(Long idDetallePedidoToUpdate, DetallePedido detallePedidoUpdated)
            throws DetallePedidoNotFoundException, MonetaryCalculationException{
        DetallePedido detalleExistente = detallePedidoRepository.findById(idDetallePedidoToUpdate)
                .orElseThrow(() -> new DetallePedidoNotFoundException(idDetallePedidoToUpdate));

        if (validarSubtotal(detallePedidoUpdated)) {
            throw new MonetaryCalculationException(
                    "Subtotal",
                    "Detalle pedido",
                    calcularSubtotal(detallePedidoUpdated));
        }
        
        detalleExistente.setCantidadVariante(detallePedidoUpdated.getCantidadVariante());
        detalleExistente.setPrecioUnitario(detallePedidoUpdated.getPrecioUnitario());
        detalleExistente.setSubTotal(detallePedidoUpdated.getSubTotal());

        detallePedidoRepository.save(detalleExistente);
    }

    public boolean validarSubtotal(DetallePedido detallePedido){
        BigDecimal calculadoSubTotal = detallePedido.getPrecioUnitario()
                .multiply(BigDecimal.valueOf(detallePedido.getCantidadVariante()));
        return !detallePedido.getSubTotal().equals(calculadoSubTotal);
    }

    public BigDecimal calcularSubtotal(DetallePedido detallePedido){
        return detallePedido.getPrecioUnitario()
                .multiply(BigDecimal.valueOf(detallePedido.getCantidadVariante()));
    }
}
