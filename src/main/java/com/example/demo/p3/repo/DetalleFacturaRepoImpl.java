package com.example.demo.p3.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.p3.modelo.DetalleFactura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Transactional
@Repository
public class DetalleFacturaRepoImpl implements IDetalleFacturaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarDetalleFactura(DetalleFactura detalleFactura) {
		entityManager.persist(detalleFactura);

	}

}
