package com.grafrio.GraficasRiobamba.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blogs")
public class Blog {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;
	 private String tituloblog;
	 private String descripcionblog;
	 private String fechablog;
	 private UUID fotoblog;
	 
	 public Blog () {
	    	
	    }

	public Blog(Long codigo, String tituloblog, String descripcionblog, String fechablog, UUID fotoblog) {
		super();
		this.codigo = codigo;
		this.tituloblog = tituloblog;
		this.descripcionblog = descripcionblog;
		this.fechablog = fechablog;
		this.fotoblog = fotoblog;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTituloblog() {
		return tituloblog;
	}

	public void setTituloblog(String tituloblog) {
		this.tituloblog = tituloblog;
	}

	public String getDescripcionblog() {
		return descripcionblog;
	}

	public void setDescripcionblog(String descripcionblog) {
		this.descripcionblog = descripcionblog;
	}

	public String getFechablog() {
		return fechablog;
	}

	public void setFechablog(String fechablog) {
		this.fechablog = fechablog;
	}

	public UUID getFotoblog() {
		return fotoblog;
	}

	public void setFotoblog(UUID fotoblog) {
		this.fotoblog = fotoblog;
	}
	 
	 
}
