package com.grafrio.GraficasRiobamba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grafrio.GraficasRiobamba.service.repo.BlogServiceRepo;
import com.grafrio.GraficasRiobamba.service.repo.MensajesServiceRepo;
import com.grafrio.GraficasRiobamba.service.repo.ProductoServiceRepo;
import com.grafrio.GraficasRiobamba.service.repo.GaleariaServiceRepo;

@SpringBootApplication
public class GraficasRiobambaApplication {
	@Autowired
    ProductoServiceRepo productoServiceRepo ;
    @Autowired
	MensajesServiceRepo mensajeServiceRepo ;
	@Autowired
	BlogServiceRepo blogServiceRepo ;
	@Autowired
	GaleariaServiceRepo galeariaServiceRepo ;

	public static void main(String[] args) {
		SpringApplication.run(GraficasRiobambaApplication.class, args);
	}

}
