package com.example.imperio.service;

import com.example.imperio.dto.DistributorMasterCreateDto;

import java.util.List;

public interface DistributorMasterService {

    DistributorMasterCreateDto createDistributorMaster(DistributorMasterCreateDto distributorMasterCreateDto);

    DistributorMasterCreateDto getDistributorMaster(String distributorCode);

    List<DistributorMasterCreateDto> getAllDistributors();

    DistributorMasterCreateDto updateDistributor(String distributorCode, DistributorMasterCreateDto updatedDistributor);

    void deleteDistributor(String distributorCode);
}
