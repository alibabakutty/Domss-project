package com.domss.DistributorOrderManagementSystem.mapper;


import com.domss.DistributorOrderManagementSystem.dto.RegionMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.RegionMaster;

public class RegionMasterMapper {


    public static RegionMasterDto mapToRegionMasterDto(RegionMaster regionmastercreate){
        return new RegionMasterDto(
                regionmastercreate.getId(),
                regionmastercreate.getRegionMasterId(),
                regionmastercreate.getRegionName(),
                regionmastercreate.getRegionState(),
                regionmastercreate.getCountry()
        );
    }


    public static RegionMaster mapToRegionMaster(RegionMasterDto regionmastercreatedto){

        return new RegionMaster(
                regionmastercreatedto.getId(),
                regionmastercreatedto.getRegionMasterId(),
                regionmastercreatedto.getRegionName(),
                regionmastercreatedto.getRegionState(),
                regionmastercreatedto.getCountry()
        );
    }


}
