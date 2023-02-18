package com.example.demo.p3.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.p3.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;


@Transactional
@Repository
public class ItemsRepoImpl implements IItemsRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarItems(Item item) {
		this.entityManager.persist(item);
		
	}

	@Override
	public Item consutarItem(Integer id) {
		Item item= this.entityManager.find(Item.class, id);
		return item;
	}

	@Override
	public Item consutarNamedNativeQuery(String barras) {
		TypedQuery<Item> query=this.entityManager.createNamedQuery("Item.consultaritem", Item.class);
		query.setParameter("codigoIngresado", barras);
		
		
		return query.getResultList().get(0);
	}

	@Override
	public Item consutarCriteria(String barras) {
		CriteriaBuilder criteriaBuilder=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Item> criteriaQuery =criteriaBuilder.createQuery(Item.class);
		Root<Item> root=criteriaQuery.from(Item.class);
		
		Predicate p1=criteriaBuilder.equal(root.get("codigoBarras") , barras);
		
		criteriaQuery.select(root).where(p1);
		
		TypedQuery<Item> query=this.entityManager.createQuery(criteriaQuery);
		
		
		return query.getResultList().get(0);
	}
	


}
