package com.domss.DistributorOrderManagementSystem.repository;

import com.domss.DistributorOrderManagementSystem.entity.DistributorMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorMasterRepository extends JpaRepository<DistributorMaster, String> {

    boolean existsByDistributorCode(String distributorCode);
}
