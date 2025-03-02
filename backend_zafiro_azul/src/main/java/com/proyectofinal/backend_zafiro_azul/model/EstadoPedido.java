package com.proyectofinal.backend_zafiro_azul.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
public class EstadoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @NotBlank(message = "El nombre de estado no puede ser vacío")
    @Size(max = 50, message = "El nombre de un estado no puede tener más de 50 caracteres.")
    @Column(nullable = false)
    private String nombreEstado;

    @OneToMany(mappedBy = "estadoPedido", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pedido> pedidos;

    public EstadoPedido(Long idEstado, String nombreEstado) {
        this.idEstado = idEstado;
        this.nombreEstado = nombreEstado;
    }

    public EstadoPedido() {
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
