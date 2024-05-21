package com.api.WarehouseManagementApplication.controller;

import com.api.WarehouseManagementApplication.dto.ProductDto;
import com.api.WarehouseManagementApplication.dto.ProductRequestDto;
import com.api.WarehouseManagementApplication.model.Product;
import com.api.WarehouseManagementApplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductRequestDto product){
        if (productService.createProduct(product)==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return ResponseEntity.ok(productService.createProduct(product));

        }
    }

    @PostMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestParam String name,@RequestParam Long number,@RequestParam Long id){

            return ResponseEntity.ok(productService.updateProduct(name,number,id));

    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());

    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));

    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable(name = "categoryId") Long categoryId){
        return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteProduct(id);
    }
}
