package com.api.WarehouseManagementApplication.service;

import com.api.WarehouseManagementApplication.dto.ProductDto;
import com.api.WarehouseManagementApplication.dto.ProductRequestDto;
import com.api.WarehouseManagementApplication.dto.mapper.ProductDtoConverter;
import com.api.WarehouseManagementApplication.model.Category;
import com.api.WarehouseManagementApplication.model.Product;
import com.api.WarehouseManagementApplication.model.User;
import com.api.WarehouseManagementApplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter converter;

    private final CategoryService categoryService;
    private final UserService userService;

    public ProductDto createProduct(ProductRequestDto product){
        if(categoryService.isCategory(product.getCategoryId())){
            return null;
        }

        return converter.convert(productRepository.save(Product.builder().name(product.getName())
                        .number(product.getNumber())
                        .category(categoryService.findByIdCategory(product.getCategoryId()))
                .build()));
    }

    public List<ProductDto> findAllProducts(){
        return converter.convert(productRepository
                .findAll());

    }
    public List<ProductDto> getProductsByCategory(Long categoryId){
        Category category=new Category();
        category.setId(categoryId);
        return converter.convert(productRepository.findAllByCategory(category));

    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public ProductDto updateProduct(String name, Long number,Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(name);
        product.setNumber(number);
        return converter.convert(productRepository.save(product)) ;
    }

    public ProductDto findById(Long id) {
        return converter.convert(productRepository.findById(id).orElseThrow());
    }
}
