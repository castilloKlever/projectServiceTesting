package com.grafrio.GraficasRiobamba.interfaces;

import java.util.List;
import java.util.Optional;

import com.grafrio.GraficasRiobamba.entities.Blog;



public interface IblogService {
	public List<Blog> listar();
	public Optional<Blog>listarId (Long id);
	public int save(Blog b);
	public void delete(Long id);
}
