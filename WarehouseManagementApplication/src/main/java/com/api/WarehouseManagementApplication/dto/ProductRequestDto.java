package com.api.WarehouseManagementApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequestDto {
    private Long id;

    private String name;

    private Long number;

    private Long categoryId;


}
