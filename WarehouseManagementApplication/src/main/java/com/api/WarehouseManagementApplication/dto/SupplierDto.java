package com.api.WarehouseManagementApplication.dto;

import com.api.WarehouseManagementApplication.model.Order;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {

    private Long id;

    private String name;

    private String address;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
