package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.GodownMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GodownMasterRepository extends JpaRepository<GodownMaster,String> {

    boolean existsByGodownCode(String godownCode);

}
