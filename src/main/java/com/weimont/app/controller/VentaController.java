package com.weimont.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weimont.app.repository.VentaRepository;

@Controller
@RequestMapping({ "/ventas" })
public class VentaController {

	@Autowired
	VentaRepository ventaRepository;
	
	@GetMapping({ "/mostrar" })
    public String mostrarVentas(Model model) {
        model.addAttribute("ventas", ventaRepository.findAll());
        return "ventas/ver_ventas";
    }
}
