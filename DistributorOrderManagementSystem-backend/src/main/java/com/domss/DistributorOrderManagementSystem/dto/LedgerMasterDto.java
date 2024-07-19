package com.domss.DistributorOrderManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LedgerMasterDto {

    private Long id;

    private String ledgerCode;

    private String ledgerName;

}
