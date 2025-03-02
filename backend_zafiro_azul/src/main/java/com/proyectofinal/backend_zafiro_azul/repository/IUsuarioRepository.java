package com.proyectofinal.backend_zafiro_azul.repository;

import com.proyectofinal.backend_zafiro_azul.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoUsuario(String correo);
}
