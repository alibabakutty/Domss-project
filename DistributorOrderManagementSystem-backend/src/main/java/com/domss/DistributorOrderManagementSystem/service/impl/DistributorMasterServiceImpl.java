package com.domss.DistributorOrderManagementSystem.service.impl;


import com.domss.DistributorOrderManagementSystem.dto.DistributorMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.DistributorMaster;
import com.domss.DistributorOrderManagementSystem.exception.ResourceNotFoundException;
import com.domss.DistributorOrderManagementSystem.mapper.DistributorMasterMapper;
import com.domss.DistributorOrderManagementSystem.repository.DistributorMasterRepository;
import com.domss.DistributorOrderManagementSystem.service.DistributorMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistributorMasterServiceImpl implements DistributorMasterService {

    @Autowired
    private DistributorMasterRepository distributorMasterRepository;

    @Override
    public ResponseEntity<DistributorMasterDto> createDistributorMaster(DistributorMasterDto distributorMasterDto){
        try{
// Validate the distributor object
            validateDistributorMaster(distributorMasterDto);

            // check for duplicate entry
            if(distributorMasterRepository.existsByDistributorCode(distributorMasterDto.getDistributorCode())){
                throw new DuplicateKeyException("Duplicate entry for unique field:" + distributorMasterDto.getDistributorCode());
            }

            DistributorMaster distributorMaster = DistributorMasterMapper.mapToDistributorMaster(distributorMasterDto);
            DistributorMaster savedDistributorMaster = distributorMasterRepository.save(distributorMaster);
            return new ResponseEntity<>(DistributorMasterMapper.mapToDistributorMasterDto(savedDistributorMaster), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }




        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    private void validateDistributorMaster(DistributorMasterDto distributorMasterCreateDto){

        if(distributorMasterCreateDto.getDistributorCode() == null || distributorMasterCreateDto.getDistributorCode().isEmpty()){

            throw new IllegalArgumentException("Unique field cannot be empty");
        }
    }

    @Override
    public DistributorMasterDto getDistributorMaster(String distributorCode){
        DistributorMaster distributorMaster = distributorMasterRepository.findByDistributorCode(distributorCode).orElseThrow(()->

                new ResourceNotFoundException("Distributor is not found with this name:" + distributorCode));

        return DistributorMasterMapper.mapToDistributorMasterDto(distributorMaster);
    }

    @Override
    public List<DistributorMasterDto> getAllDistributors(){
        List<DistributorMaster> distributorMaster = distributorMasterRepository.findAll();

        return distributorMaster.stream().map(DistributorMasterMapper::mapToDistributorMasterDto).toList();

    }

    @Override
    public DistributorMasterDto updateDistributor(String distributorCode, DistributorMasterDto updatedDistributor){

        DistributorMaster distributorMaster = distributorMasterRepository.findByDistributorCode(distributorCode).orElseThrow(()->

                new ResourceNotFoundException("Distributor is not found with this name:" + distributorCode));

        distributorMaster.setId(updatedDistributor.getId());
        distributorMaster.setDistributorCode(updatedDistributor.getDistributorCode());
        distributorMaster.setDistributorCompanyName(updatedDistributor.getDistributorCompanyName());
        distributorMaster.setDistributorOwnerName(updatedDistributor.getDistributorOwnerName());
        distributorMaster.setMobileNo(updatedDistributor.getMobileNo());
        distributorMaster.setExecutiveCode(updatedDistributor.getExecutiveCode());
        distributorMaster.setExecutiveMaster(updatedDistributor.getExecutiveMaster());
        distributorMaster.setRegionCode(updatedDistributor.getRegionCode());
        distributorMaster.setRegionMaster(updatedDistributor.getRegionMaster());
        distributorMaster.setContactPersonName(updatedDistributor.getContactPersonName());
        distributorMaster.setContactMobileNo(updatedDistributor.getContactMobileNo());

        DistributorMaster distributorMasterObj = distributorMasterRepository.save(distributorMaster);

        return DistributorMasterMapper.mapToDistributorMasterDto(distributorMasterObj);
    }

    @Override
    public void deleteDistributor(String distributorCode){
        DistributorMaster distributorMaster = distributorMasterRepository.findByDistributorCode(distributorCode).orElseThrow(()->

                new ResourceNotFoundException("Distributor is not exists with this name:" + distributorCode));

        distributorMasterRepository.deleteById(Long.valueOf(distributorCode));
    }
}
