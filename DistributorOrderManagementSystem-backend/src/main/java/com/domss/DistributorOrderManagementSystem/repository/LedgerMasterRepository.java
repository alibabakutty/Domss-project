package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.LedgerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LedgerMasterRepository extends JpaRepository<LedgerMaster,Long> {

    boolean existsByLedgerCode(String ledgerCode);

    Optional<LedgerMaster> findByLedgerCode(String ledgerCode);

}
