package com.ssyedhamed.productapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssyedhamed.productapp.entity.Product;
import com.ssyedhamed.productapp.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/add-product")
	public String addProductPage(Model model) {
		model.addAttribute("title", "Add Product Form");
		return "addproduct";
	}
//	@ResponseBody
	@RequestMapping(path="/add", method = RequestMethod.POST)
	public String addProductToDatabase(@ModelAttribute Product product, HttpServletRequest request) {
		this.productService.addProduct(product);
		System.out.println(product);
		String path=request.getContextPath()+"/";
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String allProducts(Model m) {
		List<Product> products = this.productService.getProducts();
		m.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping("/delete/{pid}")
	public String delete(@PathVariable int pid) {
		this.productService.deleteProduct(pid);
		return "redirect:/";
		
	}
//	@ResponseBody
	@RequestMapping("/update/{pid}")
	public String updatePage(@PathVariable int pid, Model m) {
		Product product = this.productService.getProduct(pid);
		System.out.println(product);
		m.addAttribute("product",product);
		return "editproduct";
	}
	@RequestMapping("/update-handler")
	public String update(@ModelAttribute Product product) {
		System.out.println(product);
		this.productService.updateProduct(product);
		return "redirect:/";
		
	}
}
