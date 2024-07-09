package com.domss.DistributorOrderManagementSystem.service;


import com.domss.DistributorOrderManagementSystem.dto.LedgerMasterDto;

import java.util.List;

public interface LedgerMasterService {
    LedgerMasterDto createLedgerMaster(LedgerMasterDto ledgerMasterDto);

    LedgerMasterDto getLedgerCode(String ledgerCode);

    List<LedgerMasterDto> getAllLedgerCodes();

    LedgerMasterDto updateLedgerMaster(String ledgerCode, LedgerMasterDto updatedLedgerMaster);

    void deleteLedgerMaster(String ledgerCode);
}
