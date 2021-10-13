package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ItemException;
import com.example.demo.Model.Item;
import com.example.demo.Repo.ItemsRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemsRepository itemRepo;
	
	@Override
	public List<Item> getAll() {
		return itemRepo.findAll();
	}

	@Override
	public Item getById(Long id) {
		return itemRepo.findById(id).orElse(null);
	}

	@Override
	public Item addItem(Item item) throws ItemException {
		if(item!=null) {
			if(itemRepo.existsById(item.getIcode())) {
				throw new ItemException("Item Already Exists");
			}else {
				item = itemRepo.save(item);
			}
		}
		return item;
	}

	@Override
	public Item update(Item item) throws ItemException {
		if(item!=null) {
			if(!itemRepo.existsById(item.getIcode())) {
				throw new ItemException("Item not found to update");
			}else {
				item=itemRepo.save(item);		
			}
		}
		return item;	
	}

	@Override
	public void deleteById(Long id) throws ItemException {
		if(!itemRepo.existsById(id)) {
			throw new ItemException("Item not found to delete");
		}else {
			itemRepo.deleteById(id);
		}		
	}

}
