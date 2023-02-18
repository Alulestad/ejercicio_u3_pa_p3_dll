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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

	//ITEM == PRODUYCTO 
	/*
	Id
• Cantidad
• Precio Unitario
• Subtotal
• Id Venta
• Id Producto
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "detalle_factura_seq")
	@SequenceGenerator(name = "detalle_factura_seq",sequenceName = "detalle_factura_seq",allocationSize = 1)
	@Column(name = "id_detalle_factura")
	private Integer id;
	@Column(name = "cantidad_detalle_factura")
	private Integer cantidad;
	@Column(name = "precioUnitario_detalle_factura")
	private BigDecimal precioUnitario;
	@Column(name = "subtotal_detalle_factura")
	private BigDecimal subtotal;
	
	
	//una factura tiene varios detalles
	//private Integer idVenta;//factura

	@ManyToOne
	@JoinColumn(name = "idVenta")
	private Factura factura;
	
	//los detalles tienen varios productos
		//private Integer idProducto;//item one to one
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto")
	private Item items;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Item getItems() {
		return items;
	}

	public void setItems(Item items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subtotal=" + subtotal + "]";
	}
	
	
	
	
	
	
	
	
}
