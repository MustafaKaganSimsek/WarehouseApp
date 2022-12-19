package com.api.WarehouseManagementApplication.service;

import com.api.WarehouseManagementApplication.dto.CategoryDto;
import com.api.WarehouseManagementApplication.dto.mapper.CategoryDtoConverter;
import com.api.WarehouseManagementApplication.model.Category;
import com.api.WarehouseManagementApplication.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryDtoConverter converter;


    public CategoryDto createCategory(Category category){
        return converter.convert(categoryRepository.save(category));
    }

    public CategoryDto findByIdCategory(Long id){
        Optional<Category>category=categoryRepository.findById(id);
        return converter.convert(category.isPresent()?category.get():null);
    }

    public Category findByIdCategoryForService(Long id){
        Optional<Category>category=categoryRepository.findById(id);
        return category.isPresent()?category.get():null;
    }


    public List<CategoryDto> findAllCategory(Category category){
        return converter.convert(categoryRepository.findAll());
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
