package com.example.imperio.service;

import com.example.imperio.dto.LedgerMasterCreateDto;

import java.util.List;

public interface LedgerMasterService {
    LedgerMasterCreateDto createLedgerMaster(LedgerMasterCreateDto ledgerMasterCreateDto);

    LedgerMasterCreateDto getLedgerCode(String ledgerCode);

    List<LedgerMasterCreateDto> getAllLedgerCodes();

    LedgerMasterCreateDto updateLedgerMaster(String ledgerCode, LedgerMasterCreateDto updatedLedgerMaster);

    void deleteLedgerMaster(String ledgerCode);
}
