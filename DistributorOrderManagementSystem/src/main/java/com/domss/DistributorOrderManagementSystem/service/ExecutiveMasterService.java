package com.domss.DistributorOrderManagementSystem.service;



import com.domss.DistributorOrderManagementSystem.dto.ExecutiveMasterDto;

import java.util.List;

public interface ExecutiveMasterService {

    ExecutiveMasterDto createExecutiveMaster(ExecutiveMasterDto executiveMasterDto);

    ExecutiveMasterDto getExecutiveMaster(String executiveCode);

    List<ExecutiveMasterDto> getAllExecutiveMasterCodes();

    ExecutiveMasterDto updateExecutive(String executiveCode, ExecutiveMasterDto updatedExecutive);

    void deleteExecutive(String executiveCode);
}
