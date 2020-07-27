package com.grafrio.GraficasRiobamba.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grafrio.GraficasRiobamba.entities.Producto;
import com.grafrio.GraficasRiobamba.repository.ProductoRepo;
import com.grafrio.GraficasRiobamba.services.PictureService;

@Controller
@RequestMapping("/productos")

public class ProductoControlador {
	@Autowired
	private ProductoRepo repo;
	
	@Autowired
		PictureService picService;
	
	@RequestMapping("")
	public String index() {
		return("index");
	}
	
	@GetMapping("/add")
	public String showSignUpForm(Producto producto) {
		return "add_product";
	}
	
	@GetMapping("/list")
	public String showProductos(Model model) {
		model.addAttribute("products", repo.findAll());
		return "list_products";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "/login";
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@RequestMapping ("/private")
	public String showPrivate(Model model) {
		model.addAttribute("products", repo.findAll());
		return "list_products";
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@PostMapping ("/add")
	public String addProduct(Producto producto, BindingResult result, Model model, @RequestParam("file") MultipartFile file, String categoria, Long codigo, String nombre, String descripcion, int cantidad, float precio) {
			if (result.hasErrors()) {
				return "add_product";
			}
			
			UUID idPic = UUID.randomUUID();
			picService.uploadPicture(file, idPic);
			producto.setFoto(idPic);
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setPrecio(precio);
			producto.setCategoria(categoria);
			repo.save(producto);
			return "redirect:list";
	
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping ("/edit/{id}")
	public String showUpdateForm(@PathVariable("codigo") Long codigo, Model model) {
		Producto producto = repo.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Codigo del producto invalido: " + codigo));
		model.addAttribute("product",producto);
		return "update_producto";
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping ("/update/{id}")
	public String updateProduct(@PathVariable("codigo") Long codigo, Producto producto, BindingResult result, Model model, @RequestParam("file") MultipartFile file, String categoria, String nombre, String descripcion, int cantidad, float precio ) {
		if(result.hasErrors()) {
			producto.setCodigo(codigo);//****************************************
			return "update_product";
		}
		
		if(!file.isEmpty()) {
			UUID idPic = UUID.randomUUID();
			picService.uploadPicture(file, idPic);
			producto.setFoto(idPic);
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setPrecio(precio);
			producto.setCategoria(categoria);
						
		}
		
		repo.save(producto);
		return "redirect:/productos:/list";
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping ("/delete/{id}")
	public String deleteProduct(@PathVariable("codigo") Long codigo, Model model) {
		Producto producto = repo.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Codigo del producto invalido: " + codigo));
		picService.deletePicture(producto.getFoto());
		repo.delete(producto);
		model.addAttribute("products", repo.findAll());
		return "list_products";
	}
		
}
