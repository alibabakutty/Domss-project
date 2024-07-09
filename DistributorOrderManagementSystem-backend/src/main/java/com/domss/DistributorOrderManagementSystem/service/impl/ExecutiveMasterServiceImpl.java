package com.domss.DistributorOrderManagementSystem.service.impl;

import com.domss.DistributorOrderManagementSystem.dto.ExecutiveMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.ExecutiveMaster;
import com.domss.DistributorOrderManagementSystem.exception.ResourceNotFoundException;
import com.domss.DistributorOrderManagementSystem.mapper.ExecutiveMasterMapper;
import com.domss.DistributorOrderManagementSystem.repository.ExecutiveMasterRepository;
import com.domss.DistributorOrderManagementSystem.service.ExecutiveMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExecutiveMasterServiceImpl implements ExecutiveMasterService {

    @Autowired
    private ExecutiveMasterRepository executiveMasterRepository;

    @Override
    public ExecutiveMasterDto createExecutiveMaster(ExecutiveMasterDto executiveMasterDto){

        // Validate the executive object
        validateExecutiveMaster(executiveMasterDto);

        // Check for duplicate entry
        if(executiveMasterRepository.existsByExecutiveCode(executiveMasterDto.getExecutiveCode())){

            throw new DuplicateKeyException("Duplicate entry for unique field:" + executiveMasterDto.getExecutiveCode());

        }

        ExecutiveMaster executiveMasterCreate = ExecutiveMasterMapper.mapToExecutiveMaster(executiveMasterDto);

        ExecutiveMaster savedExecutiveMaster = executiveMasterRepository.save(executiveMasterCreate);

        return ExecutiveMasterMapper.mapToExecutiveMasterDto(savedExecutiveMaster);

    }

    private void validateExecutiveMaster(ExecutiveMasterDto executiveMasterDto){

        if(executiveMasterDto.getExecutiveCode() == null || executiveMasterDto.getExecutiveCode().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty!");
        }
    }


    @Override
    public ExecutiveMasterDto getExecutiveMaster(String executiveCode){

        ExecutiveMaster executiveMasterCreate = executiveMasterRepository.findById(executiveCode).orElseThrow(() ->


                new ResourceNotFoundException("Executive is not found with this name:" + executiveCode));

        return ExecutiveMasterMapper.mapToExecutiveMasterDto(executiveMasterCreate);
    }

    @Override
    public List<ExecutiveMasterDto> getAllExecutiveMasterCodes(){

        List<ExecutiveMaster> executiveMasterCreate = executiveMasterRepository.findAll();

        return executiveMasterCreate.stream().map(ExecutiveMasterMapper::mapToExecutiveMasterDto).toList();
    }

    @Override
    public ExecutiveMasterDto updateExecutive(String executiveCode, ExecutiveMasterDto updatedExecutive){

        ExecutiveMaster executiveMasterCreate = executiveMasterRepository.findById(executiveCode).orElseThrow(() ->

                new ResourceNotFoundException("Executive is not found with the given name: " + executiveCode));

        executiveMasterCreate.setExecutiveCode(updatedExecutive.getExecutiveCode());
        executiveMasterCreate.setExecutiveMaster(updatedExecutive.getExecutiveMaster());
        executiveMasterCreate.setDateOfJoin(updatedExecutive.getDateOfJoin());
        executiveMasterCreate.setMobileNo(updatedExecutive.getMobileNo());
        executiveMasterCreate.setEmailId(updatedExecutive.getEmailId());
        executiveMasterCreate.setStatus(updatedExecutive.getStatus());

        ExecutiveMaster executiveMasterCreateObj = executiveMasterRepository.save(executiveMasterCreate);

        return ExecutiveMasterMapper.mapToExecutiveMasterDto(executiveMasterCreateObj);
    }

    @Override
    public void deleteExecutive(String executiveCode){

        ExecutiveMaster executiveMasterCreate = executiveMasterRepository.findById(executiveCode).orElseThrow(() ->

                new ResourceNotFoundException("Executive is not exists with this given name: " + executiveCode));

        executiveMasterRepository.deleteById(executiveCode);
    }
}



