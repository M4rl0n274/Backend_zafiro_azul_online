package com.proyectofinal.backend_zafiro_azul.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class UsuarioTemporal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioTemp;

    @Column(nullable = false)
    private String nombreUsuarioTemp;

    @Column(nullable = false)
    private String correoUsuarioTemp;

    @Column(nullable = false)
    private String telefonoUsuarioTemp;

    @Column(nullable = false)
    private String direccionUsuarioTemp;

    @OneToMany(mappedBy = "usuarioTemp", cascade = CascadeType.ALL)
    //@JsonIgnore
    private List<Pedido> pedidos;


    public UsuarioTemporal(String nombre_Usuario_Temp, String correo_Usuario_Temp, String telefono_Usuario_Temp, String direccion_Usuario_Temp) {
        nombreUsuarioTemp = nombre_Usuario_Temp;
        correoUsuarioTemp = correo_Usuario_Temp;
        telefonoUsuarioTemp = telefono_Usuario_Temp;
        direccionUsuarioTemp = direccion_Usuario_Temp;
    }

    public UsuarioTemporal() {
    }

    public Long getIdUsuarioTemp() {
        return idUsuarioTemp;
    }

    public void setIdUsuarioTemp(Long idUsuarioTemp) {
        this.idUsuarioTemp = idUsuarioTemp;
    }

    public String getNombreUsuarioTemp() {
        return nombreUsuarioTemp;
    }

    public void setNombreUsuarioTemp(String nombreUsuarioTemp) {
        this.nombreUsuarioTemp = nombreUsuarioTemp;
    }

    public String getCorreoUsuarioTemp() {
        return correoUsuarioTemp;
    }

    public void setCorreoUsuarioTemp(String correoUsuarioTemp) {
        this.correoUsuarioTemp = correoUsuarioTemp;
    }

    public String getTelefonoUsuarioTemp() {
        return telefonoUsuarioTemp;
    }

    public void setTelefonoUsuarioTemp(String telefonoUsuarioTemp) {
        this.telefonoUsuarioTemp = telefonoUsuarioTemp;
    }

    public String getDireccionUsuarioTemp() {
        return direccionUsuarioTemp;
    }

    public void setDireccionUsuarioTemp(String direccionUsuarioTemp) {
        this.direccionUsuarioTemp = direccionUsuarioTemp;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


}
