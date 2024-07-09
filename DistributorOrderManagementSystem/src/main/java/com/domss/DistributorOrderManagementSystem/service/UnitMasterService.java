package com.domss.DistributorOrderManagementSystem.service;

import com.domss.DistributorOrderManagementSystem.dto.UnitMasterDto;

import java.util.List;

public interface UnitMasterService {
    UnitMasterDto createUnitMaster(UnitMasterDto unitMasterDto);

    UnitMasterDto getUnitMaster(String productUom);

    List<UnitMasterDto> getAllUnits();

    void deleteUnit(String uom);
}
