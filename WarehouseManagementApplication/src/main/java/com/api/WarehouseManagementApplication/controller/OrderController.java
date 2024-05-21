package com.api.WarehouseManagementApplication.controller;

import com.api.WarehouseManagementApplication.dto.OrderDto;
import com.api.WarehouseManagementApplication.dto.OrderRequestDto;
import com.api.WarehouseManagementApplication.model.Order;
import com.api.WarehouseManagementApplication.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("save")
    public Order save(@RequestBody OrderRequestDto order){
        return orderService.save(order);
    }

    @PostMapping("update/:id")
    public Order update(@RequestBody OrderRequestDto order,@PathVariable Long id){
        return orderService.update(order,id);
    }


    @GetMapping()
    public List<OrderDto> findAll(){
        return orderService.findAll();
    }

    @GetMapping(":id")
    public OrderDto findById(@PathVariable Long id){
        return orderService.findById(id);
    }

   @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){

        orderService.deleteById(id);
    }
}
