package com.grafrio.GraficasRiobamba.repository;
import java.util.List;
import org.springframework.data.repository.*;
import com.grafrio.GraficasRiobamba.entities.*;


public interface CategoriaRepo extends CrudRepository <Categoria, Long> {
	
	List<Categoria> findByNombre(String nombre);
	
	List<Categoria> findByCodigo(int codigo);
}
