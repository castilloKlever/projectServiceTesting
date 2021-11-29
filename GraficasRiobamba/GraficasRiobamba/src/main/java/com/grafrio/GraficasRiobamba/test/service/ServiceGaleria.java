package com.grafrio.GraficasRiobamba.test.service;

import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.grafrio.GraficasRiobamba.entities.Galeria;
import com.grafrio.GraficasRiobamba.service.repo.GaleariaServiceRepo;

@Service
public class ServiceGaleria {
	@Autowired
	private static GaleariaServiceRepo galeriaServiceRepo ;

	/**
	 * 
	 */
	public ServiceGaleria(GaleariaServiceRepo galeriaServiceRepo ) {
		
		ServiceGaleria.galeriaServiceRepo=galeriaServiceRepo ; 
	}
	
	@PostConstruct
	public static int  insertar() {
		
		 int resp = 0;
		 
		 try {
			Galeria galeria = new Galeria();
			galeria.setTitulo("Productos");
			galeria.setFoto(null);
			galeria.setDescripcion("abc");
		
			  
			galeriaServiceRepo.save(galeria);
				 resp = 1;
			 
		 }catch (Exception e){
			 resp = 0;
		
		
		
	}
		return resp;
	
	
	}
	public static List<Galeria> listar(){
		return (List<Galeria>)galeriaServiceRepo.findAll();
	}
	
	public static int eliminar() {
		int resp = 0 ;
		
		try {
			Long codigo = (long) 1;
			galeriaServiceRepo.deleteById(codigo);
		}catch (Exception e){
			
			resp = 0;
		}
		return resp;
	}


}
