package com.example.imperio.repository;

import com.example.imperio.entity.LedgerMasterCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerMasterDAO extends JpaRepository<LedgerMasterCreate,String> {

    boolean existsByLedgerCode(String ledgerCode);

}
