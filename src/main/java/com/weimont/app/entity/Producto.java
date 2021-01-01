package com.weimont.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_articulos")
    private Integer id;

	@Column(name="nombre")
    private String nombre;

	@Column(name="codigo")
    private String codigo;

	@Column(name="precio")
    private Float precio;

	@Column(name="existencia")
    private Float existencia;

	public Producto(Integer id, String nombre, String codigo, Float precio, Float existencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.existencia = existencia;
	}

	public Producto(String nombre, String codigo, Float precio, Float existencia) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.existencia = existencia;
	}
	
	public Producto() {
	}
	
	public boolean sinExistencia() {
		return this.existencia == 0;
	}
	
	public void restarExistencia(Float existencia) {
		this.existencia = this.existencia - existencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getExistencia() {
		return existencia;
	}

	public void setExistencia(Float existencia) {
		this.existencia = existencia;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio
				+ ", existencia=" + existencia + "]";
	}
	
	
	
}
