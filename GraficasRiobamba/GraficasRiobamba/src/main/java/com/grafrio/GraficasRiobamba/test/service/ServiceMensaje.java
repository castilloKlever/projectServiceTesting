package com.grafrio.GraficasRiobamba.test.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.grafrio.GraficasRiobamba.entities.Mensaje;
import com.grafrio.GraficasRiobamba.service.repo.MensajesServiceRepo;


@Service
public class ServiceMensaje {
	@Autowired
	private static MensajesServiceRepo mensajeServiceRepo ;

	public ServiceMensaje(MensajesServiceRepo mensajeServiceRepo) {
	
		ServiceMensaje.mensajeServiceRepo = mensajeServiceRepo;
	}
	@PostConstruct
	public static int  insertar() {
		
		 int resp = 0;
		 
		 try {
			 Mensaje mensaje = new Mensaje();
			  mensaje.setContenido("Prueba de test");
			  mensaje.setTelefonoCliente("099999");
			  mensaje.setCorreoCliente("@vv");
			  mensaje.setNombreCliente("Fabian");
			  
			  mensajeServiceRepo.save(mensaje);
				 resp = 1;
			 
		 }catch (Exception e){
			 resp = 0;
		
		
		
	}
		return resp;
	
	
	}

	public static List<Mensaje> listar(){
		return (List<Mensaje>) mensajeServiceRepo.findAll();
	}
	
	public static int eliminar() {
		int resp = 0 ;
		
		try {
			Long codigo = (long) 1;
			mensajeServiceRepo.deleteById(codigo);
		}catch (Exception e){
			
			resp = 0;
		}
		return resp;
	}


	
}
