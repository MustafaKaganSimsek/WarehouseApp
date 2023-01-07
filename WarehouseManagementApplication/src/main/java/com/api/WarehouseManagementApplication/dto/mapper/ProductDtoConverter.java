package com.api.WarehouseManagementApplication.dto.mapper;

import com.api.WarehouseManagementApplication.dto.ProductDto;
import com.api.WarehouseManagementApplication.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Component
public class ProductDtoConverter {

    public final CategoryDtoConverter categoryDtoConverter;
    public ProductDto convert(Product from){
        return new ProductDto(from.getId(),from.getName(),from.getNumber(),from.getCategory().getName(),from.getCreatedAt(),from.getUpdatedAt());
    }
    public List<ProductDto> convert(List<Product> fromList){
        return fromList.stream()
                .map(from -> convert(from))
                .collect(Collectors.toList());
    }
}
