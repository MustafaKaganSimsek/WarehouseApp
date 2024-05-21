package com.api.WarehouseManagementApplication.service;

import com.api.WarehouseManagementApplication.dto.SupplierDto;
import com.api.WarehouseManagementApplication.model.Order;
import com.api.WarehouseManagementApplication.model.Supplier;
import com.api.WarehouseManagementApplication.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public Supplier save(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public List<SupplierDto> findAll(){
        return supplierRepository.findAll().stream().map(supplier -> SupplierDto.builder()
                .name(supplier.getName())
                .address(supplier.getAddress())
                .id(supplier.getId())
                .updateTime(supplier.getUpdatedAt())
                .createTime(supplier.getCreatedAt())
                .build()).collect(Collectors.toList());
    }

    public void deleteById(Long id){

        supplierRepository.deleteById(id);
    }

    public void update(String name, String address, Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow();
        supplier.setAddress(address);
        supplier.setName(name);
        supplierRepository.save(supplier);
    }

    public SupplierDto findById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow();

        return SupplierDto.builder()
                .name(supplier.getName())
                .address(supplier.getAddress())
                .id(supplier.getId())
                .updateTime(supplier.getUpdatedAt())
                .createTime(supplier.getCreatedAt())
                .build();
    }
}
