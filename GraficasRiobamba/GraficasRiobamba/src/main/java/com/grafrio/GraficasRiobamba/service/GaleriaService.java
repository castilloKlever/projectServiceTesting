package com.grafrio.GraficasRiobamba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grafrio.GraficasRiobamba.entities.Galeria;

import com.grafrio.GraficasRiobamba.interfaces.IgaleriaService;
import com.grafrio.GraficasRiobamba.repository.GaleriaRepo;

@Service
public class GaleriaService implements IgaleriaService {
	@Autowired
	private GaleriaRepo datagaleria;

	@Override
	public List<Galeria> listar() {
		// TODO Auto-generated method stub
		return (List<Galeria>)datagaleria.findAll();
	}

	@Override
	public Optional<Galeria> listarId(Long id) {
		// TODO Auto-generated method stub
		return datagaleria.findById(id);
	}

	@Override
	public int save(Galeria g) {
		// TODO Auto-generated method stub
		int res = 0;
		Galeria galeria = datagaleria.save(g);
		if(!galeria.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		datagaleria.deleteById(id);
	}
	

}
