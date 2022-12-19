package com.api.WarehouseManagementApplication.controller;

import com.api.WarehouseManagementApplication.dto.CategoryDto;
import com.api.WarehouseManagementApplication.model.Category;
import com.api.WarehouseManagementApplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> findByIdCategory(@PathVariable Long id){

        return ResponseEntity.ok(categoryService.findByIdCategory(id));
    }
}
