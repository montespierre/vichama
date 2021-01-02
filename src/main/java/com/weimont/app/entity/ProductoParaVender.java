package com.weimont.app.entity;

public class ProductoParaVender extends Producto{

	private static final long serialVersionUID = 1L;

	private Float cantidad;
	
	public ProductoParaVender(String nombre, String codigo, Float precio, Float existencia, Integer id, Float cantidad) {
		super(id, nombre, codigo, precio, existencia);
		this.cantidad = cantidad;
	}
	
	public ProductoParaVender(String nombre, String codigo, Float precio, Float existencia, Float cantidad) {
		super(nombre, codigo, precio, existencia);
		this.cantidad = cantidad;
	}
	
	public void aumentarCantidad() {
        this.cantidad++;
    }
	
	public Float getCantidad() {
        return cantidad;
    }
	
	public Float getTotal() {
        return this.getPrecio() * this.cantidad;
    }
}
