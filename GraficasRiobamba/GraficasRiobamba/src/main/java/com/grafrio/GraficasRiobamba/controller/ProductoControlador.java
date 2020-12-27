package com.grafrio.GraficasRiobamba.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grafrio.GraficasRiobamba.entities.Blog;
import com.grafrio.GraficasRiobamba.entities.Galeria;
import com.grafrio.GraficasRiobamba.entities.Mensaje;
import com.grafrio.GraficasRiobamba.entities.Producto;
import com.grafrio.GraficasRiobamba.interfaces.IblogService;
import com.grafrio.GraficasRiobamba.interfaces.IgaleriaService;
import com.grafrio.GraficasRiobamba.interfaces.ImensajeService;
import com.grafrio.GraficasRiobamba.interfaces.IproductoService;
import com.grafrio.GraficasRiobamba.service.PictureService;



@Controller
@RequestMapping("/PortafolioEmpresarial")

public class ProductoControlador {

	 @Autowired
	 private IproductoService  service;
	 @Autowired
	 private ImensajeService  serviceMensaje ;
	 @Autowired
	 private IgaleriaService galeriaService;
	 @Autowired
	 private IblogService blogService;
	 
	 @Autowired
	    PictureService picService;
	 
	 @RequestMapping("")
	 public String login() {
	     return "login";
	 }
	
	 @RequestMapping("/login")
	 public String mostrarLogin() {
	     return "login.html";
	 }
	 
	 @GetMapping("/index")
	 public String mostrarIndex(Model model) {
		 List<Producto>producto=service.listar();
		 model.addAttribute("productos", producto);
		 List<Galeria>galeria=galeriaService.listar();
		 model.addAttribute("galerias", galeria);
		 return "index";
	 }
	 @GetMapping("/about")
	 public String mostrarAbout(Model model) {
		 return "about";
	 }
	 
	 @GetMapping("/portafolio")
	 public String mostrarPortafolio(Model model) {
		 model.addAttribute("mensaje", new Mensaje());
		 List<Producto>producto=service.listar();
		 model.addAttribute("productos", producto);
		 return "portafolio";
	 }
	 
	 
	 @GetMapping("/gallery")
	 public String mostrarGaleria(Model model) {
		
		 List<Galeria>galeria=galeriaService.listar();
		 model.addAttribute("galerias", galeria);
		 return "gallery";
	 }
	 
	 
	 @GetMapping("/mail")
	 public String mostrarContactos(Model model) {
		 return "mail";
	 }
	 @PreAuthorize("hasAuthority('admin')")
	 @RequestMapping("/private")
	 public String ListarProducto(Model model) {
		 List<Producto>producto=service.listar();
		 model.addAttribute("productos", producto);
	     return "admin";
 
	 }
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @RequestMapping("/listar")
	 public String listar(Model model) {
		List<Producto> productos = service.listar();
		model.addAttribute("productos",productos);
		 return "admin";
	 }
	 
	 
	
	 
	 @PostMapping("/saveMensaje")
	 public String guardarMensaje (@Validated Mensaje m, Model model) {
		 serviceMensaje.save(m);  
		 return"redirect:/PortafolioEmpresarial/index";
	 }
	 
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/new")
	 public String agregarProducto(Model model) {
		 List<Producto>producto=service.listar();
		 model.addAttribute("productos", producto);
		 model.addAttribute("producto", new Producto());
		 return "new";
	 }
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/blog")
	 public String agregarBlog(Model model) {
		 List<Blog>blog=blogService.listar();
		 model.addAttribute("blogs", blog);
		 model.addAttribute("blog", new Blog());
		 return "blog";
	 }
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/new_galeria")
	 public String agregarGaleria(Model model) {
		 List<Galeria>galeria=galeriaService.listar();
		 model.addAttribute("galerias", galeria);
		
		 model.addAttribute("galeria", new Galeria());
		 return "new_galeria";
	 }
	 
	
	
	
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @PostMapping("/save")
	 public String guardarProducto (@Validated Producto p, Model model, BindingResult result , @RequestParam("file") MultipartFile file) {
		 if (result.hasErrors()) {
		        return "new";
		     }
		 UUID idPic = UUID.randomUUID();
	     picService.uploadPicture(file, idPic);
	     p.setFoto(idPic);
	     service.save(p);  
		 return"redirect:/PortafolioEmpresarial/listar";
	 }
	 
	 

	 @PreAuthorize("hasAuthority('admin')")
	 @PostMapping("/save_galeria")
	 public String guardarGaleria (@Validated Galeria g, Model model, BindingResult result , @RequestParam("file") MultipartFile file) {
		 if (result.hasErrors()) {
		        return "new_galeria";
		     }
		 UUID idPic = UUID.randomUUID();
	     picService.uploadPicture(file, idPic);
	     g.setFoto(idPic);
	     galeriaService.save(g);  
		 return"redirect:/PortafolioEmpresarial/galeria_creada";
	 }
	 
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @PostMapping("/save_blog")
	 public String guardarBlog(@Validated Blog b, Model model, BindingResult result , @RequestParam("file") MultipartFile file) {
		 if (result.hasErrors()) {
		        return "blog";
		     }
		 UUID idPic = UUID.randomUUID();
	     picService.uploadPicture(file, idPic);
	     b.setFotoblog(idPic);
	     blogService.save(b);  
		 return"redirect:/PortafolioEmpresarial/blogs_creados";
	 }
	 
	 
	 

	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/editar/{codigo}")
	 public String editarProducto(@PathVariable Long codigo, Model model) {
		 List<Producto> productos = service.listar();
		 model.addAttribute("productos",productos);
		 
		 Optional<Producto>producto = service.listarId(codigo);
		 model.addAttribute("producto",producto);
		 return("new");
	 }
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/eliminar/{codigo}")
		public String eliminarProducto(@PathVariable long codigo,Model model) {
			service.delete(codigo);
			return "redirect:/PortafolioEmpresarial/listar";
		}
	
	//CRUD PARA LOS BLOGS CREADOS 
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/blogs_creados")
	 public String alostarBlog(Model model) {
		 List<Blog>blog=blogService.listar();
		 model.addAttribute("blogs", blog);
		
		 return "blogs_creados";
	 }
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/editar_blog/{codigo}")
	 public String editarBlog(@PathVariable Long codigo, Model model) {
		 List<Blog> blogs = blogService.listar();
		 model.addAttribute("blogs",blogs);
		 
		 Optional<Blog>blog = blogService.listarId(codigo);
		 model.addAttribute("blog",blog);
		 return("blog");
	 }
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/eliminar_blog/{codigo}")
		public String eliminarBlog(@PathVariable long codigo,Model model) {
			blogService.delete(codigo);
			return "redirect:/PortafolioEmpresarial/blogs_creados";
		}
     
	 //CRUD PARA LAS GALERIAS CREADAS 
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/galeria_creada")
	 public String listarGaleria(Model model) {
		 List<Galeria>galeria=galeriaService.listar();
		 model.addAttribute("galerias", galeria);
		
		 return "galeria_creada";
	 }
	
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/editar_galeria/{codigo}")
	 public String editarGaleria(@PathVariable Long codigo, Model model) {
		 List<Galeria> galerias = galeriaService.listar();
		 model.addAttribute("galerias",galerias);
		 
		 Optional<Galeria>galeria = galeriaService.listarId(codigo);
		 model.addAttribute("galeria",galeria);
		 return("new_galeria");
	 }
	 
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/eliminar_galeria/{codigo}")
		public String eliminarGaleria(@PathVariable long codigo,Model model) {
			galeriaService.delete(codigo);
			return "redirect:/PortafolioEmpresarial/galeria_creada";
		}
	 
	
	 
	 
	}
	
		
	 
	 