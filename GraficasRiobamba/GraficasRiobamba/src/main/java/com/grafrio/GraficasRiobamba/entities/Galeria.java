package com.grafrio.GraficasRiobamba.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "galerias")
public class Galeria {
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long codigo;
	    private String titulo;
	    private String descripcion;
	    private UUID foto;
	    public Galeria () {
	    	
	    }
		public Galeria(Long codigo, String titulo, String descripcion, UUID foto) {
			super();
			this.codigo = codigo;
			this.titulo = titulo;
			this.descripcion = descripcion;
			this.foto = foto;
		}

		public Long getCodigo() {
			return codigo;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public UUID getFoto() {
			return foto;
		}

		public void setFoto(UUID foto) {
			this.foto = foto;
		}
	    
	    

}
