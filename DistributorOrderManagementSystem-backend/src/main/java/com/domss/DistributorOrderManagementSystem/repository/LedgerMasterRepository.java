package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.LedgerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerMasterRepository extends JpaRepository<LedgerMaster,String> {

    boolean existsByLedgerCode(String ledgerCode);

}
