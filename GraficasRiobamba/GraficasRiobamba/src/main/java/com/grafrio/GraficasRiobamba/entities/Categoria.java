package com.grafrio.GraficasRiobamba.entities;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("unused")
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigoCategoria;
    private String nombre;
    private Long codigoProducto;
/* METODOS SET Y GET PARA EL CAMPO CODIGO CATEGORIA  */
    public Long getCodigoCategoria() {
        return codigoCategoria;
    }
    public void setcodigoCategoria(Long codigoCategoria) {
        this.codigoCategoria= codigoCategoria;
    }
    
 /* METODOS SET Y GET PARA EL CAMPO NOMBRE  */   
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /* METODOS SET Y GET PARA EL CAMPO CODIGO PRODUCTO */
    public Long getCodigoProducto() {
        return codigoProducto;
    }
    public void setCodigoProducto(Long codigoProducto) {
        this.codigoProducto= codigoProducto;
    }
    


}


