package com.domss.DistributorOrderManagementSystem.service.impl;

import com.domss.DistributorOrderManagementSystem.dto.RegionMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.RegionMaster;
import com.domss.DistributorOrderManagementSystem.exception.ResourceNotFoundException;
import com.domss.DistributorOrderManagementSystem.mapper.RegionMasterMapper;
import com.domss.DistributorOrderManagementSystem.repository.RegionMasterRepository;
import com.domss.DistributorOrderManagementSystem.service.RegionMasterService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionMasterServiceImpl implements RegionMasterService {

    @Autowired
    private RegionMasterRepository regionMasterRepository;

    @Override
    public RegionMasterDto createRegionMaster(RegionMasterDto regionMasterDto){

        // Validate the region object
        validateRegionMaster(regionMasterDto);

        // Check for duplicate entry
        if (regionMasterRepository.existsByRegionMasterId(regionMasterDto.getRegionMasterId())) {
            throw new DuplicateKeyException("Duplicate entry for unique field: " + regionMasterDto.getRegionMasterId());
        }

        RegionMaster regionMaster = RegionMasterMapper.mapToRegionMaster(regionMasterDto);

        RegionMaster savedRegionMaster = regionMasterRepository.save(regionMaster);

        return RegionMasterMapper.mapToRegionMasterDto(savedRegionMaster);


    }

    private void validateRegionMaster(RegionMasterDto regionMasterDto){

        if(regionMasterDto.getRegionMasterId() == null || regionMasterDto.getRegionMasterId().isEmpty()){

            throw new IllegalArgumentException("Unique field cannot be empty");
        }
    }


    @Override
    public RegionMasterDto getRegionMaster(String regionMasterId){

        RegionMaster regionMaster = regionMasterRepository.findByRegionMasterId(regionMasterId).orElseThrow(() ->
                new ResourceNotFoundException("Region is not found with this name:" + regionMasterId));

        return RegionMasterMapper.mapToRegionMasterDto(regionMaster);
    }


    @Override
    public List<RegionMasterDto> getAllRegionMasterIds(){

        List<RegionMaster> regionMaster = regionMasterRepository.findAll();
        return regionMaster.stream().map(RegionMasterMapper::mapToRegionMasterDto).toList();
    }

    @Override
    public RegionMasterDto updateRegion(String regionMasterId, RegionMasterDto updatedRegion){

        RegionMaster regionMaster = regionMasterRepository.findByRegionMasterId(regionMasterId).orElseThrow(() ->

                new ResourceNotFoundException("Region is not found with the given name: " + regionMasterId));

        regionMaster.setId(updatedRegion.getId());
        regionMaster.setRegionMasterId(updatedRegion.getRegionMasterId());
        regionMaster.setRegionName(updatedRegion.getRegionName());
        regionMaster.setRegionState(updatedRegion.getRegionState());
        regionMaster.setCountry(updatedRegion.getCountry());

        RegionMaster regionMasterObj = regionMasterRepository.save(regionMaster);

        return RegionMasterMapper.mapToRegionMasterDto(regionMasterObj);

    }

    @Override
    public void deleteRegion(String regionMasterId){

        RegionMaster regionMaster = regionMasterRepository.findByRegionMasterId(regionMasterId).orElseThrow(() ->

                new ResourceNotFoundException("Region is not exists with the given name: " + regionMasterId));

        regionMasterRepository.deleteById(Long.valueOf(regionMasterId));
    }
}
