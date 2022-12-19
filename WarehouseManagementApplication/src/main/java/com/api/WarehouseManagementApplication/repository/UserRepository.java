package com.api.WarehouseManagementApplication.repository;

import com.api.WarehouseManagementApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmail(String mail);
}
