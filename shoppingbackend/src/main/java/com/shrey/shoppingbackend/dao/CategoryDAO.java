package com.shrey.shoppingbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shrey.shoppingbackend.dto.Category;

@Repository()
public interface CategoryDAO {

	
	List<Category> list();
	Category get(int id);
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);	
}
