package com.api.WarehouseManagementApplication.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;

    private String productName;

    private String supplierName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
