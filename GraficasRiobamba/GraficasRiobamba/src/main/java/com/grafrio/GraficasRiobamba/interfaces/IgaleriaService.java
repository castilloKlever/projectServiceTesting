package com.grafrio.GraficasRiobamba.interfaces;

import java.util.List;
import java.util.Optional;

import com.grafrio.GraficasRiobamba.entities.Galeria;


public interface IgaleriaService {
	public List<Galeria> listar();
	public Optional<Galeria>listarId (Long id);
	public int save(Galeria g);
	public void delete(Long id);
}
