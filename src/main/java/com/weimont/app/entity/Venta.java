package com.weimont.app.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="v_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_idVenta")
	private Integer id;
	
	@Column(name="fechaYHora")
	private String fechaYHora;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "venta")
	private Set<ProductoVendido> productos;
	
	public Venta() {
		this.fechaYHora = Utiles.obtenerFechaYHoraActual();
	}
	
	public Float getTotal() {
		Float total = 0f;
		
		for(ProductoVendido productoVendido : this.productos) {
			total += productoVendido.getTotal();
		}
		
		return total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(String fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public Set<ProductoVendido> getProductos() {
		return productos;
	}

	public void setProductos(Set<ProductoVendido> productos) {
		this.productos = productos;
	}
	
	
	
}
