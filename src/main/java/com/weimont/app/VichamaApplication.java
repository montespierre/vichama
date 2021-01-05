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
			
			Producto producto1 = new Producto(1, "Lapiz", "1001", 20.56F, 100.56F);
			Producto producto2 = new Producto(2, "Plumon", "1002", 21.56F, 200.56F);
			Producto producto3 = new Producto(3, "Papel", "1003", 22.56F, 300.56F);
			Producto producto4 = new Producto(4, "Tijera", "1004", 23.56F, 4000.56F);
			Producto producto5 = new Producto(5, "Corrector", "1005", 11.56F, 4000.56F);
			Producto producto6 = new Producto(6, "Pioner", "1006", 12.56F, 4000.56F);
			Producto producto7 = new Producto(7, "Engrapador", "1007", 13.56F, 4000.56F);
			Producto producto8 = new Producto(8, "Cartulina", "1008", 14.56F, 4000.56F);
			Producto producto9 = new Producto(9, "Lapicero", "1009", 15.56F, 4000.56F);
			Producto producto10 = new Producto(10, "Libro", "1010", 16.56F, 4000.56F);
		
			
			productoRepository.save(producto1);
			productoRepository.save(producto2);
			productoRepository.save(producto3);
			productoRepository.save(producto4);
			productoRepository.save(producto5);
			productoRepository.save(producto6);
			productoRepository.save(producto7);
			productoRepository.save(producto8);
			productoRepository.save(producto9);
			productoRepository.save(producto10);

		
	
			
		};
	}

}
