package com.project.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.payloads.CategoryDto;
import com.project.blog.services.CateoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CateoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categDto) {

		CategoryDto createCategory = this.categoryService.createCategory(categDto);
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);

	}

	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable Integer catId) {

		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);

	}
	
	// this delete category is different from what is made in tutorial - 
	@DeleteMapping("/{catId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer catId){

		this.categoryService.deleteCategory(catId);
		return new ResponseEntity(Map.of("message","category deleted successfully"),HttpStatus.OK);
	}
	
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
		
		CategoryDto categoryDto = this.categoryService.getCategory(catId);
		
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		
		List<CategoryDto> categories = this.categoryService.getCategories();
		
		return  ResponseEntity.ok(categories);
	}
	
	
	
	

}
