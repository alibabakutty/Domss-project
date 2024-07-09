package com.example.imperio.service.impl;

import com.example.imperio.dto.LedgerMasterCreateDto;
import com.example.imperio.entity.LedgerMasterCreate;
import com.example.imperio.exception.ResourceNotFoundException;
import com.example.imperio.mapper.LedgerMasterCreateMapper;
import com.example.imperio.repository.LedgerMasterDAO;
import com.example.imperio.service.LedgerMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LedgerMasterServiceImpl implements LedgerMasterService {

    @Autowired
    private LedgerMasterDAO ledgerMasterDAO;

    @Override
    public LedgerMasterCreateDto createLedgerMaster(LedgerMasterCreateDto ledgerMasterCreateDto){

        // Validate for duplicate entry
        validateLedgerTypeMaster(ledgerMasterCreateDto);

        // Check for duplicate entry
        if(ledgerMasterDAO.existsByLedgerCode(ledgerMasterCreateDto.getLedgerCode())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + ledgerMasterCreateDto.getLedgerCode());
        };

        LedgerMasterCreate ledgerMasterCreate = LedgerMasterCreateMapper.mapToLedgerMasterCreate(ledgerMasterCreateDto);

        LedgerMasterCreate savedLedgerMasterCreate = ledgerMasterDAO.save(ledgerMasterCreate);

        return LedgerMasterCreateMapper.mapToLedgerMasterCreateDto(savedLedgerMasterCreate);

    }

    private void validateLedgerTypeMaster(LedgerMasterCreateDto ledgerMasterCreateDto){
        if(ledgerMasterCreateDto.getLedgerCode() == null || ledgerMasterCreateDto.getLedgerCode().isEmpty()){
            throw new IllegalArgumentException("Unique field Cannot be empty");
        }
    }


    @Override
    public LedgerMasterCreateDto getLedgerCode(String ledgerCode){
        LedgerMasterCreate ledgerMasterCreate = ledgerMasterDAO.findById(ledgerCode).orElseThrow(()->

                new ResourceNotFoundException("Ledger Code is not found with this name:" + ledgerCode));

        return LedgerMasterCreateMapper.mapToLedgerMasterCreateDto(ledgerMasterCreate);
    }

    @Override
    public List<LedgerMasterCreateDto> getAllLedgerCodes(){
        List<LedgerMasterCreate> ledgerMasterCreate = ledgerMasterDAO.findAll();

        return ledgerMasterCreate.stream().map(LedgerMasterCreateMapper::mapToLedgerMasterCreateDto).toList();

    }


    @Override
    public LedgerMasterCreateDto updateLedgerMaster(String ledgerCode, LedgerMasterCreateDto updatedLedgerMaster){

        LedgerMasterCreate ledgerMasterCreate = ledgerMasterDAO.findById(ledgerCode).orElseThrow(()->

                new ResourceNotFoundException("Ledger Code is not found with this name:" + ledgerCode));

        ledgerMasterCreate.setLedgerCode(updatedLedgerMaster.getLedgerCode());
        ledgerMasterCreate.setLedgerName(updatedLedgerMaster.getLedgerName());

        LedgerMasterCreate ledgerMasterCreateObj = ledgerMasterDAO.save(ledgerMasterCreate);

        return LedgerMasterCreateMapper.mapToLedgerMasterCreateDto(ledgerMasterCreateObj);

    }

    @Override
    public void deleteLedgerMaster(String ledgerCode){
        LedgerMasterCreate ledgerMasterCreate = ledgerMasterDAO.findById(ledgerCode).orElseThrow(()->

                new ResourceNotFoundException("Ledger Code is not found with this name:" + ledgerCode));

        ledgerMasterDAO.deleteById(ledgerCode);

    }
}
