package com.example.demo.Service;

import java.util.List;


import com.example.demo.Exception.ItemException;
import com.example.demo.Model.Item;

public interface ItemService {

	
	List<Item> getAll();
	Item getById(Long id);
	Item addItem(Item item) throws ItemException;
	Item update(Item item) throws ItemException;
	void deleteById(Long id) throws ItemException;
}
