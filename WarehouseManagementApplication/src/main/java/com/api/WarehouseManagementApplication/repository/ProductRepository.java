package com.api.WarehouseManagementApplication.repository;

import com.api.WarehouseManagementApplication.model.Category;
import com.api.WarehouseManagementApplication.model.Product;
import com.api.WarehouseManagementApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByCategory(Category category);

}
