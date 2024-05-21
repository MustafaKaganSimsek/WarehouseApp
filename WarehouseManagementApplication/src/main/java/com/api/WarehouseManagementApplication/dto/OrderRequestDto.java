package com.api.WarehouseManagementApplication.dto;

import com.api.WarehouseManagementApplication.model.Product;
import com.api.WarehouseManagementApplication.model.Supplier;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class OrderRequestDto {


    private Long suppleirId;

    private Long productId;
}
