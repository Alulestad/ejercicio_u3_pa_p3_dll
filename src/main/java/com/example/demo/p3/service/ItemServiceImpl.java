package com.example.demo.p3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.p3.modelo.Item;
import com.example.demo.p3.repo.IItemsRepo;

import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.TypedQuery;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemsRepo iItemsRepo;
	
	@Override
	public void insertarItems(Item item) {
		// TODO Auto-generated method stub
		this.iItemsRepo.insertarItems(item);
	}

	@Override
	public Item consutarItem(Integer id) {
		// TODO Auto-generated method stub
		return iItemsRepo.consutarItem(id);
	}
	

	@Override
	public Integer consutarStokItem(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Integer consutarNamedNativeQuery(String barras) {
		// TODO Auto-generated method stub
		
		return iItemsRepo.consutarNamedNativeQuery(barras).getStock();
	}

	@Override
	public Integer consutarStokConCriteria(String barras) {
		// TODO Auto-generated method stub
		return iItemsRepo.consutarCriteria(barras).getStock();
	}

}
