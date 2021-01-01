package com.weimont.app;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.weimont.app.entity.Producto;
import com.weimont.app.repository.ProductoRepository;



@SpringBootApplication
public class VichamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VichamaApplication.class, args);
	}
	
	@Bean
	ApplicationRunner applicationRunner(ProductoRepository productoRepository) {
		return args -> {
			
			Producto producto1 = new Producto(1, "Carlos", "1000", 20.56F, 100.56F);
			Producto producto2 = new Producto(2, "Juan", "1001", 21.56F, 200.56F);
			Producto producto3 = new Producto(3, "Roberto", "1002", 22.56F, 300.56F);
			Producto producto4 = new Producto(4, "Yenny", "1003", 23.56F, 4000.56F);
		
			
			productoRepository.save(producto1);
			productoRepository.save(producto2);
			productoRepository.save(producto3);
			productoRepository.save(producto4);
		
	
			
		};
	}

}
