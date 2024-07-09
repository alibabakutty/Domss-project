package com.domss.DistributorOrderManagementSystem.service;



import com.domss.DistributorOrderManagementSystem.dto.RegionMasterDto;

import java.util.List;

public interface RegionMasterService {
    RegionMasterDto createRegionMaster(RegionMasterDto regionMasterDto);

    RegionMasterDto getRegionMaster(String regionMasterId);

    List<RegionMasterDto> getAllRegionMasterIds();

    RegionMasterDto updateRegion(String regionMasterId, RegionMasterDto updatedRegion);

    void deleteRegion(String regionMasterId);
}
