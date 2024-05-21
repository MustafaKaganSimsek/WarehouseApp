package com.api.WarehouseManagementApplication.repository;

import com.api.WarehouseManagementApplication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
