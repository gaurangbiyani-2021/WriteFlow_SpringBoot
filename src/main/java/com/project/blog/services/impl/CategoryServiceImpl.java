package com.project.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.entities.Category;
import com.project.blog.payloads.CategoryDto;
import com.project.blog.repositories.CategoryRepo;
import com.project.blog.services.CateoryService;

@Service
public class CategoryServiceImpl implements CateoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);

		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(IllegalArgumentException::new);

		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updatedcat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub

		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(IllegalArgumentException::new);
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub

		List<Category> categories = this.categoryRepo.findAll();

		// map the category values into the categoryDto values and put them as a list 
		List<CategoryDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());

		return catDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(IllegalArgumentException::new);
		this.categoryRepo.delete(cat);

	}

}
