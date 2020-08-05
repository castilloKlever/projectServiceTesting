package com.grafrio.GraficasRiobamba.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensajes")
public class Mensaje {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long codigo;
	    private String nombreCliente;
	    private  String correoCliente ;
	    private  String telefonoCliente ;
	    private String contenido ;
	    
	    public Mensaje () {
	    	
	    }

		public Mensaje(Long codigo, String nombreCliente, String correoCliente, String telefonoCliente,
				String contenido) {
			super();
			this.codigo = codigo;
			this.nombreCliente = nombreCliente;
			this.correoCliente = correoCliente;
			this.telefonoCliente = telefonoCliente;
			this.contenido = contenido;
		}

		public Long getCodigo() {
			return codigo;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}

		public String getNombreCliente() {
			return nombreCliente;
		}

		public void setNombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
		}

		public String getCorreoCliente() {
			return correoCliente;
		}

		public void setCorreoCliente(String correoCliente) {
			this.correoCliente = correoCliente;
		}

		public String getTelefonoCliente() {
			return telefonoCliente;
		}

		public void setTelefonoCliente(String telefonoCliente) {
			this.telefonoCliente = telefonoCliente;
		}

		public String getContenido() {
			return contenido;
		}

		public void setContenido(String contenido) {
			this.contenido = contenido;
		}

}
