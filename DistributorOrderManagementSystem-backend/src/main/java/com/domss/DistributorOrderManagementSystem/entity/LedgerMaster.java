package com.domss.DistributorOrderManagementSystem.entity;

import jakarta.persistence.*;
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
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;


    @Column(name = "ledger_code", nullable = false, unique = true)
    private String ledgerCode;

    @Column(name = "ledger_name")
    private String ledgerName;
}
