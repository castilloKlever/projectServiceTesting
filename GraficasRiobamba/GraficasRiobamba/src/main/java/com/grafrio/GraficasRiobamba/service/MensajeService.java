package com.grafrio.GraficasRiobamba.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grafrio.GraficasRiobamba.entities.Mensaje;

import com.grafrio.GraficasRiobamba.interfaces.ImensajeService;
import com.grafrio.GraficasRiobamba.repository.MensajeRepo;



@Service
public class MensajeService implements ImensajeService {
	@Autowired
	private MensajeRepo datamensaje ;
	@Override
	public int save(Mensaje m) {
		int respuesta = 0;
		Mensaje mensaje = datamensaje .save(m);
		if(!mensaje.equals(null)) {
			respuesta  = 1;
		}
		return respuesta ;
	}
	
	
	

	

}
