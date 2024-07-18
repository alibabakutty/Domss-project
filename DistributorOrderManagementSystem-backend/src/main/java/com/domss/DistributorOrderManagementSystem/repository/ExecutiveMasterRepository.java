package com.domss.DistributorOrderManagementSystem.repository;

import com.domss.DistributorOrderManagementSystem.entity.ExecutiveMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExecutiveMasterRepository extends JpaRepository<ExecutiveMaster, Long> {

    boolean existsByExecutiveCode(String executiveCode);

    Optional<ExecutiveMaster> findByExecutiveCode(String executiveCode);
}
