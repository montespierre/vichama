package com.weimont.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.weimont.app.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{

	Producto findFirstByCodigo(String codigo);
}
