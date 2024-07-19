package com.domss.DistributorOrderManagementSystem.mapper;


import com.domss.DistributorOrderManagementSystem.dto.UnitMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.UnitMaster;

public class UnitMasterMapper {

    public static UnitMasterDto mapToUnitMasterDto(UnitMaster unitMaster) {
        return new UnitMasterDto(
                unitMaster.getId(),
                unitMaster.getProductUom(),
                unitMaster.getUom()
        );
    }

    public static UnitMaster mapToUnitMaster(UnitMasterDto unitMasterDto) {
        return new UnitMaster(
                unitMasterDto.getId(),
                unitMasterDto.getProductUom(),
                unitMasterDto.getUom()
        );
    }
}
