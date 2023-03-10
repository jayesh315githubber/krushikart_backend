package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Categorys;

import com.app.pojos.Products;
import com.app.service.ProductInterface;


@RestController
@RequestMapping("/api/prod")
public class ProductController {

	@Autowired
	private ProductInterface prodImpl;

	@GetMapping
	public List<Products> getDatailsOfSeeds() {

		return prodImpl.getAllSeedsData();
	}

	@PostMapping
	public void addNewProduct(@RequestBody Products Obj,String catName) {
		prodImpl.addNewSeeds(Obj,catName);
	}

	@DeleteMapping("/{prodId}")
	public void deleteSeedById(@PathVariable Long prodId) {
		prodImpl.removeSeedDetails(prodId);
	}

	@PutMapping
	public void updateSeedInfo(@RequestBody Products prodId) {
		prodImpl.updateSeedProdDetails(prodId);
	}
	@GetMapping("/{catName}")
	public List<Products> getAllProductByCategory(@PathVariable String catName){
		return prodImpl.getAllProductByProducts(catName);
	}
}
