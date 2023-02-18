package com.example.demo.p3.service;

import com.example.demo.p3.modelo.Item;

public interface IItemService {

	
	public void insertarItems(Item item);
	
	public Item consutarItem(Integer id);
	
	public Integer consutarStokItem(Integer id);
	
	public Integer consutarNamedNativeQuery(String barras);
	
	public Integer consutarStokConCriteria(String barras);
	
	
}
