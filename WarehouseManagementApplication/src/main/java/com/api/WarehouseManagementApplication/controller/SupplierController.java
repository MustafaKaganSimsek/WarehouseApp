package com.api.WarehouseManagementApplication.controller;

import com.api.WarehouseManagementApplication.dto.OrderRequestDto;
import com.api.WarehouseManagementApplication.dto.SupplierDto;
import com.api.WarehouseManagementApplication.model.Order;
import com.api.WarehouseManagementApplication.model.Supplier;
import com.api.WarehouseManagementApplication.service.OrderService;
import com.api.WarehouseManagementApplication.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping("save")
    public Supplier save(@RequestBody Supplier supplier){
        return supplierService.save(supplier);
    }

    @PostMapping("update/{id}")
    public void update(@RequestParam String name,@RequestParam String address ,@PathVariable Long id){
        supplierService.update(name,address,id);
    }

    @GetMapping()
    public List<SupplierDto> findAll(){
        return supplierService.findAll();
    }

    @GetMapping("{id}")
    public SupplierDto findById(@PathVariable Long id){
        return supplierService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){

        supplierService.deleteById(id);
    }
}
