
package com.grafrio.GraficasRiobamba.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
    private String categoria;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private float precio;
    private UUID foto;
/* METODOS SET Y GET PARA EL CAMPO CODIGO  */
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo= codigo;
    }
    
  /* METODOS SET Y GET PARA EL CAMPO CATEGORIA  */
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
 /* METODOS SET Y GET PARA EL CAMPO NOMBRE  */   
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
 /* METODOS SET Y GET PARA EL CAMPO DESCRIPCION  */    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion= descripcion;
    }
    
    /* METODOS SET Y GET PARA EL CAMPO CANTIDAD  */    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad= cantidad;
    }
      
    
    /* METODOS SET Y GET PARA EL CAMPO PRECIO  */    
    public float getPrecio() {
        return precio;
    }
    
    public void setCantidad(float precio) {
        this.precio= precio;
    }
      
  /* METODOS SET Y GET PARA EL CAMPO FOTOGRAFIA */
    
    public UUID getFoto() {
        return foto;
    }
    public void setFoto(UUID foto) {
        this.foto = foto;
    }    
    
    


}