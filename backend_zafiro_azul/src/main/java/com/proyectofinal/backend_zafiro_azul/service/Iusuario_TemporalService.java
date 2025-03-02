package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.UsuarioTemporal;

import java.util.List;

public interface Iusuario_TemporalService {

    List <UsuarioTemporal> getUsuario_Temporal();

    //guardar
    public void saveUsuario_Temporal (UsuarioTemporal tempo);

    public void deleteUsuario_Temporal(Long id);

    public UsuarioTemporal findUsuario_Temporal(long id);

    public void editUsuario_Temporal(Long id,
                                     UsuarioTemporal UsuarioTemporalActualizado);
    


}
