package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.GodownMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GodownMasterRepository extends JpaRepository<GodownMaster,Long> {

    boolean existsByGodownCode(String godownCode);

    Optional<GodownMaster> findByGodownCode(String godownCode);

}
