package com.domss.DistributorOrderManagementSystem.mapper;


import com.domss.DistributorOrderManagementSystem.dto.LedgerMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.LedgerMaster;

public class LedgerMasterMapper {

    public static LedgerMasterDto mapToLedgerMasterDto(LedgerMaster ledgerMaster){
        return new LedgerMasterDto(
                ledgerMaster.getLedgerCode(),
                ledgerMaster.getLedgerName()
        );
    }

    public static LedgerMaster mapToLedgerMaster(LedgerMasterDto ledgerMasterDto){
        return new LedgerMaster(
                ledgerMasterDto.getLedgerCode(),
                ledgerMasterDto.getLedgerName()
        );
    }
}
