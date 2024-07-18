package com.domss.DistributorOrderManagementSystem.mapper;


import com.domss.DistributorOrderManagementSystem.dto.GodownMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.GodownMaster;

public class GodownMasterMapper {


    public static GodownMasterDto mapToGodownMasterDto(GodownMaster godownMaster){
        return new GodownMasterDto(
                godownMaster.getId(),
                godownMaster.getGodownCode(),
                godownMaster.getGodownName()
        );
    }


    public static GodownMaster mapToGodownMaster(GodownMasterDto godownMasterCreateDto){
        return new GodownMaster(
                godownMasterCreateDto.getId(),
                godownMasterCreateDto.getGodownCode(),
                godownMasterCreateDto.getGodownName()
        );
    }
}
