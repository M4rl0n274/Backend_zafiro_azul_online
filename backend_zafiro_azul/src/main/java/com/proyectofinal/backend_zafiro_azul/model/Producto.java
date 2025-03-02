package com.proyectofinal.backend_zafiro_azul.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private String imagenProducto;

    @OneToMany(mappedBy = "producto")
    private List<VarianteProducto> variantes;

    @ManyToMany
    @JoinTable(
            name = "Producto_categoria_producto_intermedia",
            joinColumns = @JoinColumn(name = "idProducto"),
            inverseJoinColumns = @JoinColumn(name = "idCategoria")
    )
    private List<CategoriaProducto> categorias;

    public Producto(Long idProducto, String imagenProducto, String nombreProducto) {
        this.idProducto = idProducto;
        this.imagenProducto = imagenProducto;
        this.nombreProducto = nombreProducto;
    }

    public Producto(){
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public List<VarianteProducto> getVariantes() {return variantes;}

    public void setVariantes(List<VarianteProducto> variantes) {this.variantes = variantes;}

    public List<CategoriaProducto> getCategorias() {return categorias;}

    public void setCategorias(List<CategoriaProducto> categorias) {this.categorias = categorias;}


}
