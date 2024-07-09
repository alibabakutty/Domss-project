package com.example.imperio.mapper;


import com.example.imperio.dto.LedgerMasterCreateDto;
import com.example.imperio.entity.LedgerMasterCreate;

public class LedgerMasterCreateMapper {

    public static LedgerMasterCreateDto mapToLedgerMasterCreateDto(LedgerMasterCreate ledgerMasterCreate){
        return new LedgerMasterCreateDto(
                ledgerMasterCreate.getLedgerCode(),
                ledgerMasterCreate.getLedgerName()
        );
    }

    public static LedgerMasterCreate mapToLedgerMasterCreate(LedgerMasterCreateDto ledgerMasterCreateDto){
        return new LedgerMasterCreate(
                ledgerMasterCreateDto.getLedgerCode(),
                ledgerMasterCreateDto.getLedgerName()
        );
    }
}
