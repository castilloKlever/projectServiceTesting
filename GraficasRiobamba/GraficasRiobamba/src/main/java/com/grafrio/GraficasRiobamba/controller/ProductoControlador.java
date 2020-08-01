package com.grafrio.GraficasRiobamba.controller;

import java.util.UUID;

import javax.print.PrintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grafrio.GraficasRiobamba.entities.Producto;
import com.grafrio.GraficasRiobamba.repository.ProductoRepo;
import com.grafrio.GraficasRiobamba.service.PictureService;








@Controller
@RequestMapping("/GraficasRiobamba")

public class ProductoControlador {

	 @Autowired
	 private ProductoRepo repo;
	 @Autowired
	    PictureService picService;
	 
	 @RequestMapping("")
	 public String login() {
	     return "login";
	 }
	
	 @RequestMapping("/login")
	 public String showLogin() {
	     return "login.html";
	 }
	 
	 @RequestMapping("/index")
	 public String showIndex(Model model) {
		 model.addAttribute("products", repo.findAll());
	     return "index";
 
	 }
	 @PreAuthorize("hasAuthority('admin')")
	 @RequestMapping("/private")
	 public String showPrivate(Model model) {
		 model.addAttribute("products", repo.findAll());
	     return "admin";
 
	 }
	 @PreAuthorize("hasAuthority('admin')")
	 @PostMapping("/add")
	 public String addRecipe(Producto producto, BindingResult result, Model model, @RequestParam("file") MultipartFile file) {
	     if (result.hasErrors()) {
	        return "admin";
	     }
	     UUID idPic = UUID.randomUUID();
	     picService.uploadPicture(file, idPic);
	     producto.setFoto(idPic);
	     repo.save(producto);   
	     return "redirect:list";
	 }

	 
	}
	
		
	 
	 /*

    
	 @PreAuthorize("hasAuthority('admin')")
	 @PostMapping("/add")
	 public String addRecipe(Producto producto, BindingResult result, Model model, @RequestParam("file") MultipartFile file) {
	     if (result.hasErrors()) {
	        return "admin";
	     }
	     UUID idPic = UUID.randomUUID();
	     picService.uploadPicture(file, idPic);
	     producto.setFoto(idPic);
	     repo.save(producto);   
	     return "redirect:list";
	 }
	 
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/edit/{id}")
	 public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		 Producto producto= repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + id));
	     model.addAttribute("products", producto);
	     return "admin";
	 }
	 
	 @PreAuthorize("hasAuthority('admin')")
	 @PostMapping("/update/{id}")
	 public String updateRecipe(@PathVariable("id") Long id, Producto producto, BindingResult result, Model model, @RequestParam("file") MultipartFile file) {
	     if (result.hasErrors()) {
	    	 producto.setCodigo(id);
	          return "admin";
	     }
	     
	     if (!file.isEmpty()) {
	    	 picService.deletePicture(producto.getFoto());
		     UUID idPic = UUID.randomUUID();
		     picService.uploadPicture(file, idPic);
		     producto.setFoto(idPic);
	     }
	     repo.save(producto);
	     return "redirect:/GraficasRiobamba/list";
	 }

	 @PreAuthorize("hasAuthority('admin')")
	 @GetMapping("/delete/{id}")
	 public String deleteRecipe(@PathVariable("id") Long id, Model model) {
		 Producto producto = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid recipe Id:" + id));
	     picService.deletePicture(producto.getFoto());
	     repo.delete(producto);	     
	     model.addAttribute("products", repo.findAll());
	     return "admin";
	 } 
	  */

