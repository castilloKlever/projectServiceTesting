package com.grafrio.GraficasRiobamba.repository;

import java.util.List;

public interface ProductoRepo extends CrudRepository <Producto, Long> {
	
	List<Producto> findByNombre(String nombre);
	
	List<Producto> findByCodigo(int codigo);
}
