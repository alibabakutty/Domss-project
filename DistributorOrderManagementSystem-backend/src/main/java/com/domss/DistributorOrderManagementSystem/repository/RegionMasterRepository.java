package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.RegionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionMasterRepository extends JpaRepository<RegionMaster,Long> {

   boolean existsByRegionMasterId(String regionMasterId);

   Optional<RegionMaster> findByRegionMasterId(String regionMasterId);
}
