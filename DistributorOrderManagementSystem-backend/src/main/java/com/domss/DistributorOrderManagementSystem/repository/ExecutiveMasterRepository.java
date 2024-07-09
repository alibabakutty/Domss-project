package com.domss.DistributorOrderManagementSystem.repository;

import com.domss.DistributorOrderManagementSystem.entity.ExecutiveMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutiveMasterRepository extends JpaRepository<ExecutiveMaster, String> {

    boolean existsByExecutiveCode(String executiveCode);
}
