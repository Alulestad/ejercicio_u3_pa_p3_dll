package com.example.demo.p3.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	
	/*
	 * *
	Id
• Número
• Fecha
• Cedula Cliente
• Total Venta
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "factura_seq")
	@SequenceGenerator(name = "factura_seq",sequenceName = "factura_seq",allocationSize = 1)
	@Column(name = "id_factura")
	private Integer id;
	@Column(name = "numero_factura")
	private Integer numero;
	@Column(name = "fecha_factura")
	private LocalDateTime fecha;
	@Column(name = "cedula_factura")
	private String cedula;
	@Column(name = "totalVenta_factura")
	private BigDecimal totalVenta;
	
	
	@OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
	private List<DetalleFactura> detallesFactura;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public BigDecimal getTotalVenta() {
		return totalVenta;
	}


	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}


	public List<DetalleFactura> getDetallesFactura() {
		return detallesFactura;
	}


	public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
		this.detallesFactura = detallesFactura;
	}


	@Override
	public String toString() {
		return "Factura [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", cedula=" + cedula + ", totalVenta="
				+ totalVenta + "]";
	}
	
	
	

}
