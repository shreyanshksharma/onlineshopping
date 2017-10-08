package com.shrey.shoppingbackend.dao;

import java.util.List;

import com.shrey.shoppingbackend.dto.Category;


public interface CategoryDAO {

	
	List<Category> list();
	Category get(int id);
	
	
}
