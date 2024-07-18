package com.domss.DistributorOrderManagementSystem.repository;

import com.domss.DistributorOrderManagementSystem.entity.DistributorMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistributorMasterRepository extends JpaRepository<DistributorMaster, Long> {

    boolean existsByDistributorCode(String distributorCode);

    Optional<DistributorMaster> findByDistributorCode(String distributorCode); // Corrected to DistributorMaster
}
