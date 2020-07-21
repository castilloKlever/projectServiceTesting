package com.grafrio.GraficasRiobamba.entities;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class Empresa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String mision;
    private String vision;
    private String resumen;
    private String nombreServicio;
    private String descripcionServicio;
    private UUID fotoServicio;
    private String descripcionContacto;
    private String telefono;
    private String correo;
    
/* METODOS SET Y GET PARA EL CAMPO MISION   */
    public String getMision() {
        return mision;
    }
    public void setMision(String mision) {
        this.mision= mision;
    }
    
  /* METODOS SET Y GET PARA EL CAMPO VISION  */
    public String getVision() {
        return vision;
    }
    public void setVision(String vision) {
        this.vision= vision;
    }
 /* METODOS SET Y GET PARA EL CAMPO RESUMEN   */   
    
    public String getResumen() {
        return resumen;
    }
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
 /* METODOS SET Y GET PARA EL CAMPO NOMBRE DEL SERVICIO */    
    public String getNombreServicio() {
        return nombreServicio;
    }
    
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio= nombreServicio;
    }
    
    /* METODOS SET Y GET PARA EL CAMPO  DESCRIPCION DEL SERVICIO  */    

    
    public String getDescripcionServicio() {
        return descripcionServicio;
    }
    
    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio= descripcionServicio;
    }

    
/* METODOS SET Y GET PARA EL CAMPO FOTOGRAFIA */
		  
	public UUID getFotoServicio() {
		      return fotoServicio;
	}
	public void setFotoServicio(UUID fotoServicio) {
		      this.fotoServicio = fotoServicio;
	}    
  
		  
/* METODOS SET Y GET PARA EL CAMPO  DESCRIPCION DEL CONTACT  */    

		    
	public String getDescripcionContacto() {
		   return descripcionContacto;
	}
		    
    public void setDescripcionContacto(String descripcionContacto) {
		   this.descripcionContacto= descripcionContacto;
    }

/* METODOS SET Y GET PARA EL CAMPO  TELEFONO */    

    
	public String getTelefono() {
		   return telefono;
	}
		    
    public void setTelefono(String telefono) {
		   this.telefono= telefono;
    }
    /* METODOS SET Y GET PARA EL CAMPO  CORREO*/   
    public String getCorreo() {
		   return correo;
	}
		    
 public void setCorreo(String  correo) {
		   this. correo=  correo;
 }
		
		  
  
}

