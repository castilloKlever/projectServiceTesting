package com.grafrio.GraficasRiobamba.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grafrio.GraficasRiobamba.service.repo.BlogServiceRepo;
import com.grafrio.GraficasRiobamba.entities.Blog;


@Service
public class ServiceBlog {
	@Autowired
	private static BlogServiceRepo blogServiceRepo ;

	/**
	 * 
	 */
	public ServiceBlog(BlogServiceRepo blogServiceRepo) {
		ServiceBlog.blogServiceRepo= blogServiceRepo ;
		
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	public static int insertar() {
		
		 int resp = 0;
		 
		 try {
			 Blog blog = new Blog();
			 Blog blog1 = new Blog();
			 Blog blog2= new Blog();
			 Blog blog3 = new Blog();
			 
			 List<Blog> blogs= new ArrayList<>(Arrays.asList(blog, blog1,blog2,blog3));
			
			
			blog.setDescripcionblog("ABSCDE");
			blog.setFechablog("asasas");
			blog.setTituloblog("asasas");
			blog.setFotoblog(null);
			
			
			blog1.setDescripcionblog("ABSCDE");
			blog1.setFechablog("asasas");
			blog1.setTituloblog("asasas");
			blog1.setFotoblog(null);
			
			blog2.setDescripcionblog("ABSCDE");
			blog2.setFechablog("asasas");
			blog2.setTituloblog("asasas");
			blog2.setFotoblog(null);
			
			
			blog3.setDescripcionblog("ABSCDE");
			blog3.setFechablog("asasas");
			blog3.setTituloblog("asasas");
			blog3.setFotoblog(null);
			
			
			
			blogServiceRepo.saveAll(blogs);
				 resp = 1;
			 
		 }catch (Exception e){
			 resp = 0;
		
		
		
	}
		return resp;
	
	
	}
	public static List<Blog> listar(){
		return (List<Blog>)blogServiceRepo.findAll();
	}
	
	public static int eliminar() {
		int resp = 0 ;
		
		try {
			Long codigo = (long) 1;
			blogServiceRepo.deleteById(codigo);
		}catch (Exception e){
			
			resp = 0;
		}
		return resp;
	}



}
	