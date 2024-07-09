package com.domss.DistributorOrderManagementSystem.service.impl;

import com.domss.DistributorOrderManagementSystem.dto.LedgerMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.LedgerMaster;
import com.domss.DistributorOrderManagementSystem.exception.ResourceNotFoundException;
import com.domss.DistributorOrderManagementSystem.mapper.LedgerMasterMapper;
import com.domss.DistributorOrderManagementSystem.repository.LedgerMasterRepository;
import com.domss.DistributorOrderManagementSystem.service.LedgerMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LedgerMasterServiceImpl implements LedgerMasterService {

    @Autowired
    private LedgerMasterRepository ledgerMasterRepository;

    @Override
    public LedgerMasterDto createLedgerMaster(LedgerMasterDto ledgerMasterDto){

        // Validate for duplicate entry
        validateLedgerTypeMaster(ledgerMasterDto);

        // Check for duplicate entry
        if(ledgerMasterRepository.existsByLedgerCode(ledgerMasterDto.getLedgerCode())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + ledgerMasterDto.getLedgerCode());
        };

        LedgerMaster ledgerMaster = LedgerMasterMapper.mapToLedgerMaster(ledgerMasterDto);

        LedgerMaster savedLedgerMaster = ledgerMasterRepository.save(ledgerMaster);

        return LedgerMasterMapper.mapToLedgerMasterDto(savedLedgerMaster);

    }

    private void validateLedgerTypeMaster(LedgerMasterDto ledgerMasterDto){
        if(ledgerMasterDto.getLedgerCode() == null || ledgerMasterDto.getLedgerCode().isEmpty()){
            throw new IllegalArgumentException("Unique field Cannot be empty");
        }
    }


    @Override
    public LedgerMasterDto getLedgerCode(String ledgerCode){
        LedgerMaster ledgerMaster = ledgerMasterRepository.findById(ledgerCode).orElseThrow(()->

                new ResourceNotFoundException("Ledger Code is not found with this name:" + ledgerCode));

        return LedgerMasterMapper.mapToLedgerMasterDto(ledgerMaster);
    }

    @Override
    public List<LedgerMasterDto> getAllLedgerCodes(){
        List<LedgerMaster> ledgerMaster = ledgerMasterRepository.findAll();

        return ledgerMaster.stream().map(LedgerMasterMapper::mapToLedgerMasterDto).toList();

    }


    @Override
    public LedgerMasterDto updateLedgerMaster(String ledgerCode, LedgerMasterDto updatedLedgerMaster){

        LedgerMaster ledgerMaster = ledgerMasterRepository.findById(ledgerCode).orElseThrow(()->

                new ResourceNotFoundException("Ledger Code is not found with this name:" + ledgerCode));

        ledgerMaster.setLedgerCode(updatedLedgerMaster.getLedgerCode());
        ledgerMaster.setLedgerName(updatedLedgerMaster.getLedgerName());

        LedgerMaster ledgerMasterObj = ledgerMasterRepository.save(ledgerMaster);

        return LedgerMasterMapper.mapToLedgerMasterDto(ledgerMasterObj);

    }

    @Override
    public void deleteLedgerMaster(String ledgerCode){
        LedgerMaster ledgerMaster = ledgerMasterRepository.findById(ledgerCode).orElseThrow(()->

                new ResourceNotFoundException("Ledger Code is not found with this name:" + ledgerCode));

        ledgerMasterRepository.deleteById(ledgerCode);

    }
}
