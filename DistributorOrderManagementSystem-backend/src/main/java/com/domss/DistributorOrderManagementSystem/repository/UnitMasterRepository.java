package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.UnitMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitMasterRepository extends JpaRepository<UnitMaster,Long> {

    boolean existsByProductUom(String productUom);

    Optional<UnitMaster> findByProductUom(String productUom);

}
