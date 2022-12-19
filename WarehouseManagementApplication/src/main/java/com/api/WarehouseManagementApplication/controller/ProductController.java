package com.api.WarehouseManagementApplication.controller;

import com.api.WarehouseManagementApplication.dto.ProductDto;
import com.api.WarehouseManagementApplication.model.Product;
import com.api.WarehouseManagementApplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/creates")
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());

    }
    @GetMapping("/product/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable(name = "categoryId") Long categoryId){
        return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(Long id){
        productService.deleteProduct(id);
    }
}
