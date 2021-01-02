package com.weimont.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weimont.app.entity.Producto;
import com.weimont.app.entity.ProductoParaVender;
import com.weimont.app.repository.ProductoRepository;




@Controller
@RequestMapping({ "/vender" })
public class VenderController {
	
	@Autowired
	private ProductoRepository productoRepository;
	

	private ArrayList<ProductoParaVender> obtenerCarrito(HttpServletRequest request) {
        ArrayList<ProductoParaVender> carrito = (ArrayList<ProductoParaVender>) request.getSession().getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        return carrito;
    }
	
	private void guardarCarrito(ArrayList<ProductoParaVender> carrito, HttpServletRequest request) {
	    request.getSession().setAttribute("carrito", carrito);
	}
	
		
	@GetMapping({ "/" })
	public String interfazVender(Model model, HttpServletRequest request) {
	    model.addAttribute("productos", new Producto());
	    float total = 0;
	    ArrayList<ProductoParaVender> carrito = this.obtenerCarrito(request);
	    for (ProductoParaVender p: carrito) total += p.getTotal();
	    model.addAttribute("total", total);
	    return "vender/vender";
	}
	
	@PostMapping({ "/agregar" })
	public String agregarAlCarrito(@ModelAttribute Producto producto, HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    ArrayList<ProductoParaVender> carrito = this.obtenerCarrito(request);
	    Producto productoBuscadoPorCodigo = productoRepository.findFirstByCodigo(producto.getCodigo());
	    if (productoBuscadoPorCodigo == null) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto con el código " + producto.getCodigo() + " no existe")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/vender/";
	    }
	    if (productoBuscadoPorCodigo.sinExistencia()) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto está agotado")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/vender/";
	    }
	    boolean encontrado = false;
	    for (ProductoParaVender productoParaVenderActual : carrito) {
	        if (productoParaVenderActual.getCodigo().equals(productoBuscadoPorCodigo.getCodigo())) {
	            productoParaVenderActual.aumentarCantidad();
	            encontrado = true;
	            break;
	        }
	    }
	    if (!encontrado) {
	        carrito.add(new ProductoParaVender(productoBuscadoPorCodigo.getNombre(), productoBuscadoPorCodigo.getCodigo(), productoBuscadoPorCodigo.getPrecio(), productoBuscadoPorCodigo.getExistencia(), productoBuscadoPorCodigo.getId(), 1f));
	    }
	    this.guardarCarrito(carrito, request);
	    return "redirect:/vender/";
	}
}
