package com.proyectofinal.backend_zafiro_azul.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class VarianteProducto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idVariante;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    @JsonIgnore
    private Producto producto;

    @Column(name = "TAMANO_VARIANTE", nullable = false)
    private String tamanoVariante;

    @Column(nullable = false)
    private BigDecimal precioVariante;

    @Column(nullable = false)
    private int stockVariante;

    @OneToMany(mappedBy = "varianteProducto")
    @JsonIgnore
    private List<DetallePedido> detallePedidos;


    public VarianteProducto(Long idVariante, Producto producto, String tamanoVariante, BigDecimal precioVariante, int stockVariante) {
        this.idVariante = idVariante;
        this.producto = producto;
        this.tamanoVariante = tamanoVariante;
        this.precioVariante = precioVariante;
        this.stockVariante = stockVariante;
    }

    public VarianteProducto() {
    }

    public Long getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(Long idVariante) {
        this.idVariante = idVariante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getTamanoVariante() {
        return tamanoVariante;
    }

    public void setTamanoVariante(String tamanoVariante) {
        this.tamanoVariante = tamanoVariante;
    }

    public BigDecimal getPrecioVariante() {
        return precioVariante;
    }

    public void setPrecioVariante(BigDecimal precioVariante) {
        this.precioVariante = precioVariante;
    }

    public int getStockVariante() {
        return stockVariante;
    }

    public void setStockVariante(int stockVariante) {
        this.stockVariante = stockVariante;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setVariantes(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }
}
