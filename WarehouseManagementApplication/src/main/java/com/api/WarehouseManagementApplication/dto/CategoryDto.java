package com.api.WarehouseManagementApplication.dto;

import com.api.WarehouseManagementApplication.model.Product;
import com.api.WarehouseManagementApplication.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {

    private Long id;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    private List<Product> product;
//
//    private User user;

}
