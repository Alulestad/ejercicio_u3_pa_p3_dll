package com.example.demo.p3.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
@NamedNativeQuery(name="Item.consultaritem",query = "SELECT id_item, codigo_barras_item, nombre_item, precio_item, stock_item, tipo_item\r\n"
		+ "	FROM public.item where codigo_barras_item=:codigoIngresado",resultClass = Item.class)
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "item_seq")
	@SequenceGenerator(name = "item_seq",sequenceName = "item_seq",allocationSize = 1)
	@Column(name = "id_item")
	private Integer id;
	@Column(name = "codigoBarras_item")
	private String codigoBarras;
	@Column(name = "nombre_item")
	private String nombre;
	@Column(name = "tipo_item")
	private String tipo;
	@Column(name = "stock_item")
	private Integer stock;
	@Column(name = "precio_item")
	private BigDecimal precio;
	
	
	@OneToMany(mappedBy = "items", fetch = FetchType.LAZY)
	private List<DetalleFactura>  detalleFactura;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCodigoBarras() {
		return codigoBarras;
	}


	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}


	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", stock=" + stock + ", precio=" + precio + "]";
	}
	
	

}
