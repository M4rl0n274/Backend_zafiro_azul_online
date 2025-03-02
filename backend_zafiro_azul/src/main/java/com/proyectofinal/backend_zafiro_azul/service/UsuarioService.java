package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.Usuario;
import com.proyectofinal.backend_zafiro_azul.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void createUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public Usuario findUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        return usuario;
    }

    @Override
    public void updateUsuario(Long idUsuarioToUpdate, Usuario usuarioUpdated) {
        Usuario usuarioToUpdate = usuarioRepository.findById(idUsuarioToUpdate).orElse(null);

        if (usuarioToUpdate != null) {

            usuarioToUpdate.setNombreUsuario(usuarioUpdated.getNombreUsuario());
            usuarioToUpdate.setTelefonoUsuario(usuarioUpdated.getTelefonoUsuario());
            usuarioToUpdate.setCorreoUsuario(usuarioUpdated.getCorreoUsuario());
            usuarioToUpdate.setDireccionUsuario(usuarioUpdated.getDireccionUsuario());
            usuarioToUpdate.setPassword(usuarioUpdated.getPassword());

            usuarioRepository.save(usuarioToUpdate);
        }
    }

    @Override
    public Usuario findByCorreo(String correoUsuario){
        List<Usuario> usuarios = usuarioRepository.findAll();
        for(Usuario usuario : usuarios){
            if(usuario.getCorreoUsuario().equals(correoUsuario)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public Usuario loginUsuario(Usuario usuario){
        String correoUsuario = usuario.getCorreoUsuario();
        String password = usuario.getPassword();
        Usuario dbGetUsuario = findByCorreo(correoUsuario);

        if(dbGetUsuario != null){
            if (dbGetUsuario.getCorreoUsuario().equals(correoUsuario) && dbGetUsuario.getPassword().equals(password)){
                return dbGetUsuario;
            }
        }
        return null;
    }
}
