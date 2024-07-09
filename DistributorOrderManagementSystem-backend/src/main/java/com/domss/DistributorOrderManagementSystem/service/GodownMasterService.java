package com.domss.DistributorOrderManagementSystem.service;



import com.domss.DistributorOrderManagementSystem.dto.GodownMasterDto;

import java.util.List;

public interface GodownMasterService {
    GodownMasterDto createGodownMaster(GodownMasterDto godownMasterDto);

    GodownMasterDto getGodownMaster(String godownCode);

    List<GodownMasterDto> getAllGodownMasterCodes();

    GodownMasterDto updateGodown(String godownCode, GodownMasterDto updatedGodown);

    void deleteGodown(String godownCode);
}
