package com.shrey.onlineshopping.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shrey.onlineshopping.exception.ProductNotFoundException;
import com.shrey.shoppingbackend.dao.CategoryDAO;
import com.shrey.shoppingbackend.dao.ProductDAO;
import com.shrey.shoppingbackend.dto.Category;
import com.shrey.shoppingbackend.dto.Product;


@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index() {
	
		ModelAndView modelAndView =new ModelAndView("page");
		modelAndView.addObject("title","home");
		modelAndView.addObject("userClickHome",true);
		modelAndView.addObject("categories",categoryDAO.list());
		return modelAndView;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {		
		ModelAndView modelAndView = new ModelAndView("page");		
		modelAndView.addObject("title","About Us");
		modelAndView.addObject("userClickAbout",true);
		return modelAndView;				
	}	
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {		
		ModelAndView modelAndView = new ModelAndView("page");		
		modelAndView.addObject("title","Contact Us");
		modelAndView.addObject("userClickContact",true);
		return modelAndView;				
	}
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;				
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;				
	}
	
	@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView modelAndView = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//---------------------------
		
		modelAndView.addObject("title", product.getName());
		modelAndView.addObject("product", product);
		
		modelAndView.addObject("userClickShowProduct", true);
		
		
		return modelAndView;
		
	}
}
