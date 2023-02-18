package com.example.demo.p3.repo;

import com.example.demo.p3.modelo.Item;

public interface IItemsRepo {

	
	public void insertarItems(Item item);
	
	public Item consutarItem(Integer id);
	
	public Item consutarNamedNativeQuery(String barras);
	
	public Item consutarCriteria(String barras);
}
