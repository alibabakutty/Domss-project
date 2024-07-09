package com.example.imperio.service.impl;

import com.example.imperio.dto.ExecutiveMasterCreateDto;
import com.example.imperio.entity.ExecutiveMasterCreate;
import com.example.imperio.exception.ResourceNotFoundException;
import com.example.imperio.mapper.ExecutiveMasterCreateMapper;
import com.example.imperio.repository.ExecutiveMasterDAO;
import com.example.imperio.service.ExecutiveMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExecutiveMasterServiceImpl implements ExecutiveMasterService {

    @Autowired
    private ExecutiveMasterDAO executiveMasterDAO;

    @Override
    public ExecutiveMasterCreateDto createExecutiveMaster(ExecutiveMasterCreateDto executiveMasterCreateDto){

        // Validate the executive object
        validateExecutiveMaster(executiveMasterCreateDto);

        // Check for duplicate entry
        if(executiveMasterDAO.existsByExecutiveCode(executiveMasterCreateDto.getExecutiveCode())){

            throw new DuplicateKeyException("Duplicate entry for unique field:" + executiveMasterCreateDto.getExecutiveCode());

        }

        ExecutiveMasterCreate executiveMasterCreate = ExecutiveMasterCreateMapper.mapToExecutiveMasterCreate(executiveMasterCreateDto);

        ExecutiveMasterCreate savedExecutiveMaster = executiveMasterDAO.save(executiveMasterCreate);

        return ExecutiveMasterCreateMapper.mapToExecutiveMasterCreateDto(savedExecutiveMaster);

    }

    private void validateExecutiveMaster(ExecutiveMasterCreateDto executiveMasterCreateDto){

        if(executiveMasterCreateDto.getExecutiveCode() == null || executiveMasterCreateDto.getExecutiveCode().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty!");
        }
    }


    @Override
    public ExecutiveMasterCreateDto getExecutiveMaster(String executiveCode){

        ExecutiveMasterCreate executiveMasterCreate = executiveMasterDAO.findById(executiveCode).orElseThrow(() ->


                new ResourceNotFoundException("Executive is not found with this name:" + executiveCode));

        return ExecutiveMasterCreateMapper.mapToExecutiveMasterCreateDto(executiveMasterCreate);
    }

    @Override
    public List<ExecutiveMasterCreateDto> getAllExecutiveMasterCodes(){

        List<ExecutiveMasterCreate> executiveMasterCreate = executiveMasterDAO.findAll();

        return executiveMasterCreate.stream().map(ExecutiveMasterCreateMapper::mapToExecutiveMasterCreateDto).toList();
    }

    @Override
    public ExecutiveMasterCreateDto updateExecutive(String executiveCode, ExecutiveMasterCreateDto updatedExecutive){

        ExecutiveMasterCreate executiveMasterCreate = executiveMasterDAO.findById(executiveCode).orElseThrow(() ->

                new ResourceNotFoundException("Executive is not found with the given name: " + executiveCode));

        executiveMasterCreate.setExecutiveCode(updatedExecutive.getExecutiveCode());
        executiveMasterCreate.setExecutiveMaster(updatedExecutive.getExecutiveMaster());
        executiveMasterCreate.setDateOfJoin(updatedExecutive.getDateOfJoin());
        executiveMasterCreate.setMobileNo(updatedExecutive.getMobileNo());
        executiveMasterCreate.setEmailId(updatedExecutive.getEmailId());
        executiveMasterCreate.setStatus(updatedExecutive.getStatus());

        ExecutiveMasterCreate executiveMasterCreateObj = executiveMasterDAO.save(executiveMasterCreate);

        return ExecutiveMasterCreateMapper.mapToExecutiveMasterCreateDto(executiveMasterCreateObj);
    }

    @Override
    public void deleteExecutive(String executiveCode){

        ExecutiveMasterCreate executiveMasterCreate = executiveMasterDAO.findById(executiveCode).orElseThrow(() ->

                new ResourceNotFoundException("Executive is not exists with this given name: " + executiveCode));

        executiveMasterDAO.deleteById(executiveCode);
    }
}



