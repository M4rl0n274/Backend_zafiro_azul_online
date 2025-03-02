package com.proyectofinal.backend_zafiro_azul.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;


    @ManyToOne
    @JoinColumn(name= "idUsuario")
    @JsonIgnore
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "idUsuarioTemp")
    @JsonIgnore
    private UsuarioTemporal usuarioTemp;


    @ManyToOne
    @JoinColumn(name = "idEstadoPedido", nullable = false)
    @JsonIgnore
    private EstadoPedido estadoPedido;


    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "La fecha no puede estar vacía.")
    @PastOrPresent(message = "La fecha no puede futura.")
    @Column(nullable = false)
    private Date fechaPedido;


    @DecimalMin(value = "0.01", message = "El total del pedido debe ser mayor a cero.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPedido;


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(message = "Un pedido debe tener al menos un detalle de pedido.")
    @Valid
    private List<DetallePedido> detallesPedido;

    public Pedido(Date fechaPedido, Usuario usuario, EstadoPedido estadoPedido, BigDecimal totalPedido) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario registrado no puede ser nulo.");
        }
        this.fechaPedido = fechaPedido;
        this.usuario = usuario;
        this.estadoPedido = estadoPedido;
        this.totalPedido = totalPedido;
        this.usuarioTemp = null; // Asegurar que usuario temporal no se usa
    }

    public Pedido(Date fechaPedido, UsuarioTemporal usuarioTemp, EstadoPedido estadoPedido, BigDecimal totalPedido) {
        if (usuarioTemp == null) {
            throw new IllegalArgumentException("El usuario temporal no puede ser nulo.");
        }
        this.fechaPedido = fechaPedido;
        this.usuarioTemp = usuarioTemp;
        this.estadoPedido = estadoPedido;
        this.totalPedido = totalPedido;
        this.usuario = null; // Asegurar que usuario registrado no se usa
    }

    public Pedido() {
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioTemporal getUsuarioTemp() {
        return usuarioTemp;
    }

    public void setUsuarioTemp(UsuarioTemporal usuarioTemp) {
        this.usuarioTemp = usuarioTemp;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public List<DetallePedido> getDetallesPedido() {
        return detallesPedido;
    }

    public void setDetallesPedido(List<DetallePedido> detallesPedido) {
        this.detallesPedido = detallesPedido;
    }
}
