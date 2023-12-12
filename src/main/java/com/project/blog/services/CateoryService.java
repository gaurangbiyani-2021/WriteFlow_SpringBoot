package com.project.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.blog.payloads.CategoryDto;

public interface CateoryService {
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	CategoryDto getCategory(Integer categoryId);
	
	List<CategoryDto> getCategories();
	
	void deleteCategory(Integer categoryId);
}
