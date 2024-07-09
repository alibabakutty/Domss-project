package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.UnitMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitMasterRepository extends JpaRepository<UnitMaster,String> {

    boolean existsByProductUom(String productUom);
}
