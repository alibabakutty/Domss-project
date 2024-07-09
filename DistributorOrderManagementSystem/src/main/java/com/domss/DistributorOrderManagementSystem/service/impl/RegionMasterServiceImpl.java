package com.example.imperio.service.impl;

import com.example.imperio.dto.RegionMasterCreateDto;
import com.example.imperio.entity.RegionMasterCreate;
import com.example.imperio.exception.ResourceNotFoundException;
import com.example.imperio.mapper.RegionMasterCreateMapper;
import com.example.imperio.repository.RegionMasterDAO;
import com.example.imperio.service.RegionMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionMasterServiceImpl implements RegionMasterService {

    @Autowired
    private RegionMasterDAO regionMasterDAO;

    @Override
    public RegionMasterCreateDto createRegionMaster(RegionMasterCreateDto regionMasterCreateDto){

        // Validate the region object
        validateRegionMaster(regionMasterCreateDto);

        // Check for duplicate entry
        if (regionMasterDAO.existsByRegionMasterId(regionMasterCreateDto.getRegionMasterId())) {
            throw new DuplicateKeyException("Duplicate entry for unique field: " + regionMasterCreateDto.getRegionMasterId());
        }

        RegionMasterCreate regionMasterCreate = RegionMasterCreateMapper.mapToRegionMasterCreate(regionMasterCreateDto);

        RegionMasterCreate savedRegionMaster = regionMasterDAO.save(regionMasterCreate);

        return RegionMasterCreateMapper.mapToRegionMasterCreateDto(savedRegionMaster);


    }

    private void validateRegionMaster(RegionMasterCreateDto regionMasterCreateDto){

        if(regionMasterCreateDto.getRegionMasterId() == null || regionMasterCreateDto.getRegionMasterId().isEmpty()){

            throw new IllegalArgumentException("Unique field cannot be empty");
        }
    }


    @Override
    public RegionMasterCreateDto getRegionMaster(String regionMasterId){

        RegionMasterCreate regionMasterCreate = regionMasterDAO.findById(regionMasterId).orElseThrow(() ->
                new ResourceNotFoundException("Region is not found with this name:" + regionMasterId));

        return RegionMasterCreateMapper.mapToRegionMasterCreateDto(regionMasterCreate);
    }


    @Override
    public List<RegionMasterCreateDto> getAllRegionMasterIds(){

        List<RegionMasterCreate> regionMasterCreate = regionMasterDAO.findAll();
        return regionMasterCreate.stream().map(RegionMasterCreateMapper::mapToRegionMasterCreateDto).toList();
    }

    @Override
    public RegionMasterCreateDto updateRegion(String regionMasterId, RegionMasterCreateDto updatedRegion){

        RegionMasterCreate regionMasterCreate = regionMasterDAO.findById(regionMasterId).orElseThrow(() ->

                new ResourceNotFoundException("Region is not found with the given name: " + regionMasterId));

        regionMasterCreate.setRegionMasterId(updatedRegion.getRegionMasterId());
        regionMasterCreate.setRegionName(updatedRegion.getRegionName());
        regionMasterCreate.setRegionState(updatedRegion.getRegionState());
        regionMasterCreate.setCountry(updatedRegion.getCountry());

        RegionMasterCreate regionMasterCreateObj = regionMasterDAO.save(regionMasterCreate);

        return RegionMasterCreateMapper.mapToRegionMasterCreateDto(regionMasterCreateObj);

    }

    @Override
    public void deleteRegion(String regionMasterId){

        RegionMasterCreate regionMasterCreate = regionMasterDAO.findById(regionMasterId).orElseThrow(() ->

                new ResourceNotFoundException("Region is not exists with the given name: " + regionMasterId));

        regionMasterDAO.deleteById(regionMasterId);
    }
}
