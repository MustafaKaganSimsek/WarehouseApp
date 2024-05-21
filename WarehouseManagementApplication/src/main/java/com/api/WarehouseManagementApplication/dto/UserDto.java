package com.api.WarehouseManagementApplication.dto;

import com.api.WarehouseManagementApplication.model.Category;
import com.api.WarehouseManagementApplication.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;

}
