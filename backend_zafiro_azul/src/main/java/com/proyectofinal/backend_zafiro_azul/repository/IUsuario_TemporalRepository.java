package com.proyectofinal.backend_zafiro_azul.repository;


import com.proyectofinal.backend_zafiro_azul.model.UsuarioTemporal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario_TemporalRepository extends JpaRepository <UsuarioTemporal, Long> {

}
