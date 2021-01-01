package com.weimont.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weimont.app.entity.Producto;
import com.weimont.app.repository.ProductoRepository;


@Controller
@RequestMapping({ "/productos" })
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping({ "/agregar" })
	public String agregarProducto(Model model) {
		model.addAttribute("productos", new Producto());
		return "productos/agregar_producto";
	}
	
	@GetMapping({"/mostrar"})
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return "productos/ver_productos";
    }
}
