package com.grafrio.GraficasRiobamba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grafrio.GraficasRiobamba.entities.Blog;

import com.grafrio.GraficasRiobamba.interfaces.IblogService;
import com.grafrio.GraficasRiobamba.repository.BlogRepo;

@Service
public class BlogService implements IblogService {
	@Autowired
	private BlogRepo datablog;

	@Override
	public List<Blog> listar() {
		// TODO Auto-generated method stub
		return (List<Blog>)datablog.findAll();	}

	@Override
	public Optional<Blog> listarId(Long id) {
		// TODO Auto-generated method stub
		return datablog.findById(id);
	}

	@Override
	public int save(Blog b) {
		// TODO Auto-generated method stub
		int res = 0;
		Blog blog = datablog.save(b);
		if(!blog.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		datablog.deleteById(id);
	}

}
