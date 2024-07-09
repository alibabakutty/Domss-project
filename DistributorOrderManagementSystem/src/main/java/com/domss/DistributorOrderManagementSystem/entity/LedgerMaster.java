package com.domss.DistributorOrderManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ledger_master")
public class LedgerMaster {

    @Id
    @Column(name = "ledger_code")
    private String ledgerCode;

    @Column(name = "ledger_name")
    private String ledgerName;
}
