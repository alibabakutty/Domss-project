package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.RegionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionMasterRepository extends JpaRepository<RegionMaster,String> {
   boolean existsByRegionMasterId(String regionMasterId);
}
