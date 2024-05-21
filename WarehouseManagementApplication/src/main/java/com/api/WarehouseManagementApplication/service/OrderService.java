package com.api.WarehouseManagementApplication.service;

import com.api.WarehouseManagementApplication.dto.OrderDto;
import com.api.WarehouseManagementApplication.dto.OrderRequestDto;
import com.api.WarehouseManagementApplication.model.Order;
import com.api.WarehouseManagementApplication.model.Product;
import com.api.WarehouseManagementApplication.model.Supplier;
import com.api.WarehouseManagementApplication.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order save(OrderRequestDto order){

        return orderRepository.save(Order.builder()
                .product(Product.builder()
                        .id(order.getProductId())
                        .build())
                .suppleir(Supplier.builder()
                        .id(order.getSuppleirId())
                        .build())
                .build());
    }

    public List<OrderDto> findAll(){
        return orderRepository.findAll().stream().map(order ->(OrderDto.builder()
                .id(order.getId())
                .supplierName(order.getSuppleir().getName())
                .productName(order.getProduct().getName())
                .updateTime(order.getUpdatedAt())
                .createTime(order.getCreatedAt())
                .build())).collect(Collectors.toList());
    }

    public void deleteById(Long id){

        orderRepository.deleteById(id);
    }

    public Order update(OrderRequestDto order, Long id) {
        Order order_ = orderRepository.findById(id).orElseThrow();
        return orderRepository.save(order_);
    }

    public OrderDto findById(Long id){
        Order order = orderRepository.findById(id).orElseThrow();

        return OrderDto.builder()
                .id(order.getId())
                .supplierName(order.getSuppleir().getName())
                .productName(order.getProduct().getName())
                .updateTime(order.getUpdatedAt())
                .createTime(order.getCreatedAt())
                .build();
    }
}
