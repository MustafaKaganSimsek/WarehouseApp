package com.api.WarehouseManagementApplication.service;

import com.api.WarehouseManagementApplication.dto.ProductDto;
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

    public ProductDto createProduct(Product product){
        if(categoryService.isCategory(product.getCategory().getId())){
            return null;
        }
        User user = userService.findByIdUserEntity(userService.getCurrentUser().getId());
//        Category category = categoryService.findByIdCategoryForService(product.getCategory().getId());
        product.setUser(user);
        product.setCategory(product.getCategory());
        return converter.convert(productRepository.save(product));
    }

    public List<ProductDto> findAllProducts(){
        return converter.convert(productRepository
                .findAllByUser(userService
                        .findByIdUserEntity(userService.getCurrentUser().getId())));

    }
    public List<ProductDto> getProductsByCategory(Long categoryId){
        return findAllProducts()
                .stream()
                .filter(productDto -> productDto
                        .getCategory()
                        .getId()
                        .equals(categoryId))
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
