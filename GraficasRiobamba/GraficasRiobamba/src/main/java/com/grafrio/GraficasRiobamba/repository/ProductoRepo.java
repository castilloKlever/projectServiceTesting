package com.grafrio.GraficasRiobamba.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grafrio.GraficasRiobamba.entities.Producto;


public interface ProductoRepo extends CrudRepository <Producto, Long> {
	List<Producto> findByCodigo(Long codigo);
	List<Producto> findByNombre(String descripcion);
	
	
}
