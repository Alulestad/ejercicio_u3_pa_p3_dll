package com.example.demo.p3.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.p3.modelo.DetalleFactura;
import com.example.demo.p3.modelo.Item;
import com.example.demo.p3.repo.IDetalleFacturaRepo;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService {
	@Autowired
	private IDetalleFacturaRepo detalleFacturaRepo;
	
	@Override
	public void insertarDetalleFactura(DetalleFactura detalleFactura) {
		/*
		
		detalleFactura.setCantidad(2);
		detalleFactura.setItems(item);
		*/
		
		
		Item item= detalleFactura.getItems();
		BigDecimal precioUnitario=item.getPrecio();
		detalleFactura.setPrecioUnitario(precioUnitario);
		
		
		
		BigDecimal subTotal=precioUnitario.multiply(new BigDecimal(detalleFactura.getCantidad()));
		detalleFactura.setSubtotal(subTotal);
		
		//resta delstok
		Integer stok= item.getStock();
		Integer nstok=stok-detalleFactura.getCantidad();
		item.setStock(nstok);
		
		detalleFacturaRepo.insertarDetalleFactura(detalleFactura);
		
	}
	
}
