package com.proyectofinal.backend_zafiro_azul.service;


import com.proyectofinal.backend_zafiro_azul.model.VarianteProducto;
import com.proyectofinal.backend_zafiro_azul.repository.IvarianteProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VarianteProductoService implements IvarianteProductoService{

    @Autowired
    private IvarianteProductoRepository ivarianteProductoRepository;


    @Override
    public List<VarianteProducto> getAllVariantes() {
       return ivarianteProductoRepository.findAll();
    }

    @Override
    public VarianteProducto getVarianteById(Long id) {
        return ivarianteProductoRepository.findById(id).orElse(null);
    }

    @Override
    public void createVariant(VarianteProducto varianteProducto) {
    ivarianteProductoRepository.save(varianteProducto);
    }

    @Override
    public void updateVariant(long id, VarianteProducto varianteDetails) {

        VarianteProducto varianteActualizar = ivarianteProductoRepository.findById(id).orElse(null);

        if (varianteActualizar == null){
            System.out.println("No se encontro la variante");
        }else{
            varianteActualizar.setTamanoVariante(varianteDetails.getTamanoVariante());
            varianteActualizar.setPrecioVariante(varianteDetails.getPrecioVariante());
            varianteActualizar.setStockVariante(varianteDetails.getStockVariante());

            ivarianteProductoRepository.save(varianteActualizar);

        }



    }

    @Override
    public void deleteVariant(Long id) {
        if (ivarianteProductoRepository.findById(id).orElse(null)==null){
            System.out.println("La variante no existe  ");
        }else{
            ivarianteProductoRepository.deleteById(id);
            System.out.println("Variante eliminada: Id --> " + id);
        }

    }
}
