package com.grafrio.GraficasRiobamba.test.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.grafrio.GraficasRiobamba.entities.Producto;
import com.grafrio.GraficasRiobamba.service.repo.ProductoServiceRepo;


@Service
public class ServiceProducto {
	@Autowired
	private static ProductoServiceRepo productoServiceRepo ;

	public ServiceProducto(ProductoServiceRepo productoServiceRepo) {
	
		ServiceProducto.productoServiceRepo = productoServiceRepo;
	}
	
	@PostConstruct
	public static int  insertar() {
		
		 int resp = 0;
		 
		 try {
			 Producto producto= new Producto();
				producto.setNombre("Cuadernos");
				producto.setCategoria("Utiles");
				producto.setDescripcion("Cuadernos de papel reciclado");
				producto.setPrecio(12);
				producto.setCantidad(5);
				
				
				productoServiceRepo.save(producto);
				
				 resp = 1;
			 
		 }catch (Exception e){
			 resp = 0;
		
		
		
	}
		return resp;
	
	
	}
	
	public static List<Producto> listar(){
		return (List<Producto>) productoServiceRepo.findAll();
	}
	
	public static int eliminar() {
		int resp = 0 ;
		
		try {
			Long codigo = (long) 1;
			productoServiceRepo.deleteById(codigo);
		}catch (Exception e){
			
			resp = 0;
		}
		return resp;
	}


}
