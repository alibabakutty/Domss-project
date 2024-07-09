package com.domss.DistributorOrderManagementSystem.mapper;

import com.domss.DistributorOrderManagementSystem.dto.DistributorMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.DistributorMaster;

public class DistributorMasterMapper {


    public static DistributorMasterDto mapToDistributorMasterDto(DistributorMaster distributorMaster){

        return new DistributorMasterDto(distributorMaster.getDistributorCode(), distributorMaster.getDistributorCompanyName(), distributorMaster.getDistributorOwnerName(), distributorMaster.getMobileNo(), distributorMaster.getExecutiveCode(), distributorMaster.getExecutiveMaster(), distributorMaster.getRegionCode(), distributorMaster.getRegionMaster(), distributorMaster.getContactPersonName(), distributorMaster.getContactMobileNo());
    }


    public static DistributorMaster mapToDistributorMaster(DistributorMasterDto distributorMasterDto){

        return new DistributorMaster(distributorMasterDto.getDistributorCode(), distributorMasterDto.getDistributorCompanyName(), distributorMasterDto.getDistributorOwnerName(), distributorMasterDto.getMobileNo(), distributorMasterDto.getExecutiveCode(), distributorMasterDto.getExecutiveMaster(), distributorMasterDto.getRegionCode(), distributorMasterDto.getRegionMaster(), distributorMasterDto.getContactPersonName(), distributorMasterDto.getContactMobileNo());
    }
}
