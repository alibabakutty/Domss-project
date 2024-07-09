package com.example.imperio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ledger_master")
public class LedgerMasterCreate {

    @Id
    @Column(name = "ledger_code")
    private String ledgerCode;

    @Column(name = "ledger_name")
    private String ledgerName;
}
