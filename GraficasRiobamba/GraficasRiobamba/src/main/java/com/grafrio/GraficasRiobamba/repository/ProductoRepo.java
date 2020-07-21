package com.grafrio.GraficasRiobamba.repository;

import java.util.List;
import org.springframework.data.repository.*;
import com.grafrio.GraficasRiobamba.entities.*;
public interface ProductoRepo extends CrudRepository <Producto, Long> {
	
	List<Producto> findByNombre(String nombre);
	
	List<Producto> findByCodigo(int codigo);
}
