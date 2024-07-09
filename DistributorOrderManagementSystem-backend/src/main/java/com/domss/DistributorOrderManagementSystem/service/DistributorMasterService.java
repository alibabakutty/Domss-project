package com.domss.DistributorOrderManagementSystem.service;


import com.domss.DistributorOrderManagementSystem.dto.DistributorMasterDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DistributorMasterService {

    ResponseEntity<DistributorMasterDto> createDistributorMaster(DistributorMasterDto distributorMasterDto);

    DistributorMasterDto getDistributorMaster(String distributorCode);

    List<DistributorMasterDto> getAllDistributors();

    DistributorMasterDto updateDistributor(String distributorCode, DistributorMasterDto updatedDistributor);

    void deleteDistributor(String distributorCode);
}
