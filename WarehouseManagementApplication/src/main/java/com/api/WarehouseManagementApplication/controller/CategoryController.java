package com.api.WarehouseManagementApplication.controller;

import com.api.WarehouseManagementApplication.dto.CategoryDto;
import com.api.WarehouseManagementApplication.dto.mapper.CategoryDtoConverter;
import com.api.WarehouseManagementApplication.model.Category;
import com.api.WarehouseManagementApplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryDtoConverter converter;

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.createCategory(category));
    }
    @PostMapping("/update")
    public ResponseEntity<CategoryDto> updateCategory(@RequestParam String name,@RequestParam Long id){
        return ResponseEntity.ok(categoryService.updateCategory(name,id));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> findByIdCategory(@PathVariable Long id){

        return ResponseEntity.ok(converter.convert(categoryService.findByIdCategory(id)));
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> findAll(){

        return ResponseEntity.ok(categoryService.findAllCategory());
    }
}
