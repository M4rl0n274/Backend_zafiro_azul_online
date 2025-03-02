package com.proyectofinal.backend_zafiro_azul.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


import java.math.BigDecimal;

@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    @JsonIgnore
    @NotBlank(message = "Detalle pedido debe estar asociado a un pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idVariante", nullable = false)
    private VarianteProducto varianteProducto;

    @Column(nullable = false)
    @NotBlank(message = "La cantidad de variante no puede estar vacía")
    @Min(value = 1, message = "La cantidad de vairante debe ser al menos 1")
    private Integer cantidadVariante;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotBlank(message = "El precio unitario no puede estar vacío")
    @DecimalMin(value = "0.00", message = "El precio unitario no puede ser negativo")
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotBlank(message = "El subtotal no puede estar vacío")
    @DecimalMin(value = "0.00", message = "El subtotal no puede ser negativo")
    private BigDecimal subTotal;

    public DetallePedido(Long idDetalle, Pedido pedido, VarianteProducto varianteProducto, Integer cantidadVariante, BigDecimal precioUnitario, BigDecimal subTotal) {
        this.idDetalle = idDetalle;
        this.pedido = pedido;
        this.varianteProducto = varianteProducto;
        this.cantidadVariante = cantidadVariante;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }

    public DetallePedido() {}

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public VarianteProducto getVarianteProducto() {
        return varianteProducto;
    }

    public void setVarianteProducto(VarianteProducto varianteProducto) {
        this.varianteProducto = varianteProducto;
    }

    public Integer getCantidadVariante() {
        return cantidadVariante;
    }

    public void setCantidadVariante(Integer cantidadVariante) {
        this.cantidadVariante = cantidadVariante;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public VarianteProducto getVariante() {
        return varianteProducto;
    }

    public void setVariante(VarianteProducto varianteProducto) {
        this.varianteProducto = varianteProducto;
    }



}
