package com.api.WarehouseManagementApplication.dto.mapper;

import com.api.WarehouseManagementApplication.dto.CategoryDto;
import com.api.WarehouseManagementApplication.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDtoConverter {

    public CategoryDto convert(Category from){
        return new CategoryDto(from.getId(),from.getName(),from.getCreatedAt(),from.getUpdatedAt());
    }

    public List<CategoryDto> convert(List<Category> fromList){
        return fromList.stream().map(from -> convert(from)).collect(Collectors.toList());
    }
}
