package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster,Long> {

    boolean existsByProductCode(String productCode);

    Optional<ProductMaster> findByProductCode(String productCode);
}
