package com.api.WarehouseManagementApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private Long id;

    private String name;

    private Long number;

    private String category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}




