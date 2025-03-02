package com.proyectofinal.backend_zafiro_azul.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategoria;

    @NotBlank(message = "El nombre de la categoría no puede estar vacío")
    @Size(max = 50, message = "El nombre de una categoría no puede tener más de 50 carácteres")
    @Column(nullable = false, unique = true)
    String nombreCategoria;

    @NotBlank(message = "La descripción de la categoría no puede estar vacía")
    @Size(max = 255, message = "La descripción de la categoría no debe superar los 255 caracteres")
    @Column(nullable = false)
    String descripcionCategoria;

    @ManyToMany(mappedBy = "categorias", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Producto> productos;

    public CategoriaProducto(String nombreCategoria, String descripcionCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public CategoriaProducto() {}

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
