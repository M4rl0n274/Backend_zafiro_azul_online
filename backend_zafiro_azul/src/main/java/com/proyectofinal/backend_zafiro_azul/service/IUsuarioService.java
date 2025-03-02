package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.Producto;
import com.proyectofinal.backend_zafiro_azul.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getAllUsuarios();

    void createUsuario(Usuario usuario);

    void deleteUsuario(Long idUsuario);

    Usuario findUsuario(Long idUsuario);

    void updateUsuario(Long idUsuarioToUpdate, Usuario usuarioUpdated);

    Usuario findByCorreo(String correoUsuario);

    Usuario loginUsuario (Usuario usuario);
}
