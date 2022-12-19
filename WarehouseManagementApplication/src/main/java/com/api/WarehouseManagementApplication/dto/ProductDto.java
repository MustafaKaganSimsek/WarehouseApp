package com.api.WarehouseManagementApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private Long id;

    private String name;

    private Long number;

    private CategoryDto category;

//    private User user;



}
