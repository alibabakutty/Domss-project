package com.example.imperio.service.impl;


import com.example.imperio.dto.DistributorMasterCreateDto;
import com.example.imperio.entity.DistributorMasterCreate;
import com.example.imperio.exception.ResourceNotFoundException;
import com.example.imperio.mapper.DistributorMasterCreateMapper;
import com.example.imperio.repository.DistributorMasterDAO;
import com.example.imperio.service.DistributorMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistributorMasterServiceImpl implements DistributorMasterService {

    @Autowired
    private DistributorMasterDAO distributorMasterDAO;

    @Override
    public DistributorMasterCreateDto createDistributorMaster(DistributorMasterCreateDto distributorMasterCreateDto){

        // Validate the distributor object
        validateDistributorMaster(distributorMasterCreateDto);

        // check for duplicate entry
        if(distributorMasterDAO.existsByDistributorCode(distributorMasterCreateDto.getDistributorCode())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + distributorMasterCreateDto.getDistributorCode());
        }

        DistributorMasterCreate distributorMasterCreate = DistributorMasterCreateMapper.mapToDistributorMasterCreate(distributorMasterCreateDto);

        DistributorMasterCreate savedDistributorMasterCreate = distributorMasterDAO.save(distributorMasterCreate);

        return DistributorMasterCreateMapper.mapToDistributorMasterCreateDto(savedDistributorMasterCreate);

    }

    private void validateDistributorMaster(DistributorMasterCreateDto distributorMasterCreateDto){

        if(distributorMasterCreateDto.getDistributorCode() == null || distributorMasterCreateDto.getDistributorCode().isEmpty()){

            throw new IllegalArgumentException("Unique field cannot be empty");
        }
    }

    @Override
    public DistributorMasterCreateDto getDistributorMaster(String distributorCode){
        DistributorMasterCreate distributorMasterCreate = distributorMasterDAO.findById(distributorCode).orElseThrow(()->

                new ResourceNotFoundException("Distributor is not found with this name:" + distributorCode));

        return DistributorMasterCreateMapper.mapToDistributorMasterCreateDto(distributorMasterCreate);
    }

    @Override
    public List<DistributorMasterCreateDto> getAllDistributors(){
        List<DistributorMasterCreate> distributorMasterCreate = distributorMasterDAO.findAll();

        return distributorMasterCreate.stream().map(DistributorMasterCreateMapper::mapToDistributorMasterCreateDto).toList();

    }

    @Override
    public DistributorMasterCreateDto updateDistributor(String distributorCode, DistributorMasterCreateDto updatedDistributor){

        DistributorMasterCreate distributorMasterCreate = distributorMasterDAO.findById(distributorCode).orElseThrow(()->

                new ResourceNotFoundException("Distributor is not found with this name:" + distributorCode));

        distributorMasterCreate.setDistributorCode(updatedDistributor.getDistributorCode());
        distributorMasterCreate.setDistributorCompanyName(updatedDistributor.getDistributorCompanyName());
        distributorMasterCreate.setDistributorOwnerName(updatedDistributor.getDistributorOwnerName());
        distributorMasterCreate.setMobileNo(updatedDistributor.getMobileNo());
        distributorMasterCreate.setExecutiveCode(updatedDistributor.getExecutiveCode());
        distributorMasterCreate.setExecutiveMaster(updatedDistributor.getExecutiveMaster());
        distributorMasterCreate.setRegionCode(updatedDistributor.getRegionCode());
        distributorMasterCreate.setRegionMaster(updatedDistributor.getRegionMaster());
        distributorMasterCreate.setContactPersonName(updatedDistributor.getContactPersonName());
        distributorMasterCreate.setContactMobileNo(updatedDistributor.getContactMobileNo());

        DistributorMasterCreate distributorMasterCreateObj = distributorMasterDAO.save(distributorMasterCreate);

        return DistributorMasterCreateMapper.mapToDistributorMasterCreateDto(distributorMasterCreateObj);
    }

    @Override
    public void deleteDistributor(String distributorCode){
        DistributorMasterCreate distributorMasterCreate = distributorMasterDAO.findById(distributorCode).orElseThrow(()->

                new ResourceNotFoundException("Distributor is not exists with this name:" + distributorCode));

        distributorMasterDAO.deleteById(distributorCode);
    }
}
