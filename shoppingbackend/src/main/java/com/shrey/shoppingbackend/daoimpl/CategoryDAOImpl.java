package com.shrey.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shrey.shoppingbackend.dao.CategoryDAO;
import com.shrey.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	private static List<Category> categories = new ArrayList();

	static {
		
		Category category=new Category();
		category.setId(1);
		category.setDescription("this is the mobile");
		category.setName("mobile");
		categories.add(category);
		
		Category category1=new Category();
		category1.setId(2);
		category1.setDescription("this is the tv");
		category1.setName("tv");
		categories.add(category1);
		
		
		Category category2=new Category();
		category2.setId(3);
		category2.setDescription("this is the led");
		category2.setName("led");
		categories.add(category2);
		
		
		
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category category : categories)
		{
			if(category.getId()==id) return category;
		}
		
		return null;
	}
	

}
