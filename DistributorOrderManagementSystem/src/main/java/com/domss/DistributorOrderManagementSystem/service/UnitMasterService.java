package com.example.imperio.service;

import com.example.imperio.dto.UnitMasterCreateDto;

import java.util.List;

public interface UnitMasterService {
    UnitMasterCreateDto createUnitMaster(UnitMasterCreateDto unitMasterCreateDto);

    UnitMasterCreateDto getUnitMaster(String productUom);

    List<UnitMasterCreateDto> getAllUnits();

    void deleteUnit(String uom);
}
