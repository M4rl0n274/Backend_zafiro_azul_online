package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.UsuarioTemporal;
import com.proyectofinal.backend_zafiro_azul.repository.IUsuario_TemporalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Usuario_TemporalService implements Iusuario_TemporalService{

    @Autowired
    private IUsuario_TemporalRepository iUsuarioTemporalRepository;


    @Override
    public List<UsuarioTemporal> getUsuario_Temporal() {
        List<UsuarioTemporal>ListaUsuarioTemporal =
                iUsuarioTemporalRepository.findAll();
        return ListaUsuarioTemporal;
    }

    @Override
    public void saveUsuario_Temporal(UsuarioTemporal usuarioTemporal) {
        iUsuarioTemporalRepository.save(usuarioTemporal);

    }

    @Override
    public void deleteUsuario_Temporal(Long id) {
        iUsuarioTemporalRepository.deleteById(id);
    }

    @Override
    public UsuarioTemporal findUsuario_Temporal(long id) {
        UsuarioTemporal tempo =
        iUsuarioTemporalRepository.findById(id).orElse(null);
        return tempo;
    }

    @Override
    public void editUsuario_Temporal(Long id, UsuarioTemporal UsuarioTemporalActualizado) {
        UsuarioTemporal temporalExistente =
                iUsuarioTemporalRepository.findById(id).orElse(null);

        if (temporalExistente != null) {

            temporalExistente.setNombreUsuarioTemp(UsuarioTemporalActualizado.getNombreUsuarioTemp());
            temporalExistente.setCorreoUsuarioTemp(UsuarioTemporalActualizado.getCorreoUsuarioTemp());
            temporalExistente.setTelefonoUsuarioTemp(UsuarioTemporalActualizado.getTelefonoUsuarioTemp());
            temporalExistente.setDireccionUsuarioTemp(UsuarioTemporalActualizado.getDireccionUsuarioTemp());

            iUsuarioTemporalRepository.save(temporalExistente);
        }else{
            System.out.println("No se encontro ningun usuaripo con el id: "+ id);
        }



    }
}
