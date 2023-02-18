package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.p3.modelo.DetalleFactura;
import com.example.demo.p3.modelo.Item;
import com.example.demo.p3.service.IDetalleFacturaService;
import com.example.demo.p3.service.IItemService;

@SpringBootApplication
public class EjercicioU3PaP3DllApplication implements CommandLineRunner{

	@Autowired
	private IItemService iItemService;
	
	@Autowired
	private IDetalleFacturaService detalleFacturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioU3PaP3DllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Item item =new Item();
		//item.setId(1);
		item.setCodigoBarras("123");
		item.setNombre("Leche");
		item.setPrecio(new BigDecimal(2));
		item.setStock(15);
		item.setTipo("LACTEO");
		
		//1. Ingresar Items
		iItemService.insertarItems(item);
		
		//2. Realizar Factura (Venta)
		DetalleFactura detalleFactura= new DetalleFactura();
		detalleFactura.setCantidad(1);
		detalleFactura.setItems(item);
		
		//detalleFacturaService.insertarDetalleFactura(detalleFactura);
		
		//3. Consultar Stock
		Integer asdf=iItemService.consutarNamedNativeQuery("123");
		System.out.println("Stok: "+asdf);
		
		Integer criteria=iItemService.consutarStokConCriteria("123");
		System.out.println("Stok: "+criteria);
		
		//BASICAMENTE PARA LA FACTURA SERIA DE HACER UN DTO EN VEZ DE USAR FACTURA UNICAMENTE 
		//TENGO QUE AGREGAR new (paquete)ObjetoDTO(e.parametro,e.parametro...)
		//DE ESTA FORMA OBTENGO SOLO LOS ATRIBUTOS Q NECESITO
		//Ejemplo:
		// SELECT new com.....(f.id,.....) FROM Factura f 
		//Seguramente antes tenfa q hacer una consulta
		
		
	}

}
