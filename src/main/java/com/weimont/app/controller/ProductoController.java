package com.weimont.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "productos/agregar_productos";
	}

	@GetMapping({ "/mostrar" })
	public String mostrarProductos(Model model) {
		model.addAttribute("productos", productoRepository.findAll());
		return "productos/ver_productos";
	}

	@PostMapping({ "/agregar" })
	public String guardarProducto(@ModelAttribute Producto producto, BindingResult bindingResult,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			return "productos/agregar_productos";
		}

		if (productoRepository.findFirstByCodigo(producto.getCodigo()) != null) {
			redirectAttrs.addFlashAttribute("mensaje", "Ya existe un producto con ese código");
			redirectAttrs.addFlashAttribute("clase", "warning");
			return "redirect:/productos/agregar";
		}

		productoRepository.save(producto);

		redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente");
		redirectAttrs.addFlashAttribute("clase", "success");
		return "redirect:/productos/agregar";

	}
}
