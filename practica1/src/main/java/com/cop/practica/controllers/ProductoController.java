package com.cop.practica.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cop.practica.models.Producto;

@Controller
public class ProductoController {
	
	public List<Producto> listaProductos = new ArrayList<Producto>();
	
	public ProductoController() {
		
		Producto p1 = new Producto("001",
				"Telefono móvil", 200.50, "Tecnologia", 2);
		Producto p2 = new Producto("002",
				"Laptop Dell", 900.50, "Tecnologia", 2);
		Producto p3 = new Producto("003",
				"Monitor LG", 00.50, "Tecnologia", 2);
		Producto p4 = new Producto("004",
				"Pantalon Jean", 10.50, "Ropa", 1);
		Producto p5 = new Producto("005",
				"Camisa XL", 30.50, "Ropa", 1);
		Producto p6 = new Producto("006",
				"Telefono móvil 2", 240.50, "Tecnologia", 2);
		
		listaProductos.add(p1);
		listaProductos.add(p2);
		listaProductos.add(p3);
		listaProductos.add(p4);
		listaProductos.add(p5);
		listaProductos.add(p6);
		
	}
	
	@GetMapping({"index-secundario","index-sec","index-secunda"})
	public String index(Model model) {
		
		model.addAttribute("lista", listaProductos);
		
		return "index2";
	}
	
	// Guardar el producto
	@GetMapping("producto/add")
	public String irCrearProducto() {
		return "form-producto";
	}
	
	
	@PostMapping("producto/add")
	public String guardarProducto( 
			Model model ,
			@ModelAttribute("producto") Producto producto ) {
		
		listaProductos.add(producto);
		model.addAttribute("lista", listaProductos);
		
		return "index2";
		
	}
	
	//Editar Poducto
	@GetMapping("producto/edit/{id}")
	public String irEditarProducto( Model model, 
			@PathVariable("id") String id ) {
		
		for (Producto producto : listaProductos) {
			if(  producto.getCodigo().equals(id) ) {
				model.addAttribute("productoEdit", producto);
				break;
			}
		}
		
		return "form-edit-producto";
	}

	
	@PostMapping("producto/edit/{id}")
	public String editarPoducto( 
			Model model,@ModelAttribute("productoEdit") Producto productoEditado,
			@PathVariable("id") String id
		) {
		
		System.out.println(productoEditado.toString());
		
		for (int i = 0; i < listaProductos.size(); i++) {
			if(  listaProductos.get(i).getCodigo().equals(id) ) {
				listaProductos.set(i, productoEditado);
				
				break;
			}
		}
		
		model.addAttribute("lista", listaProductos);
		
		return "index2";
	}
	
	
	
	@GetMapping("/producto/borrar/{id}")
	public String borrarProducto(Model model, 
			@PathVariable("id") String id) {
		
		for (int i = 0; i < listaProductos.size(); i++) {
			if(  listaProductos.get(i).getCodigo().equals(id) ) {
				listaProductos.remove(i);
				//Salir del for una vez que ya lo encuentro.
				break;
			}
		}
		
		model.addAttribute("lista", listaProductos );
		
		return "index2";
	}
	
	
	
}
