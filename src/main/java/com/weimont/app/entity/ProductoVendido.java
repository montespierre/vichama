package com.weimont.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productoVendido")
public class ProductoVendido implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pv_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_idPV")
	private Integer id;
	
	@Column(name="cantidad")
	private Float cantidad;
	
	@Column(name="precio")
	private Float precio;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="codigo")
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "v_id")
	private Venta venta;

	public ProductoVendido(Float cantidad, Float precio, String nombre, String codigo, Venta venta) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.nombre = nombre;
		this.codigo = codigo;
		this.venta = venta;
	}
	
	public ProductoVendido() {
	}
	
	public Float getTotal() {
		return this.cantidad * this.precio;
	}
	
	public Venta getVenta() {
		return venta;
	}
	
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	public Float getPrecio() {
		return precio;
	}
	
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	public Float getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	
}
