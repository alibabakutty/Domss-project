package com.domss.DistributorOrderManagementSystem.service.impl;

import com.domss.DistributorOrderManagementSystem.dto.GodownMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.GodownMaster;
import com.domss.DistributorOrderManagementSystem.exception.ResourceNotFoundException;
import com.domss.DistributorOrderManagementSystem.mapper.GodownMasterMapper;
import com.domss.DistributorOrderManagementSystem.repository.GodownMasterRepository;
import com.domss.DistributorOrderManagementSystem.service.GodownMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GodownMasterServiceImpl implements GodownMasterService {

    @Autowired
    private GodownMasterRepository godownMasterRepository;

    @Override
    public GodownMasterDto createGodownMaster(GodownMasterDto godownMasterDto){

        // validate the godown object
        validateGodownMaster(godownMasterDto);

        // check for duplicate entry
        if(godownMasterRepository.existsByGodownCode(godownMasterDto.getGodownCode())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + godownMasterDto.getGodownCode());
        }


        GodownMaster godownMaster = GodownMasterMapper.mapToGodownMaster(godownMasterDto);

        GodownMaster savedGodownMaster = godownMasterRepository.save(godownMaster);

        return GodownMasterMapper.mapToGodownMasterDto(savedGodownMaster);

    }

    private void validateGodownMaster(GodownMasterDto godownMasterCreateDto){
        if(godownMasterCreateDto.getGodownCode() == null || godownMasterCreateDto.getGodownCode().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty");
        }
    }

    @Override
    public GodownMasterDto getGodownMaster(String godownCode){
        GodownMaster godownMaster = godownMasterRepository.findById(godownCode).orElseThrow(()->

                new ResourceNotFoundException("Godown is not found with this name:" + godownCode));

        return GodownMasterMapper.mapToGodownMasterDto(godownMaster);

    }


    @Override
    public List<GodownMasterDto> getAllGodownMasterCodes(){

        List<GodownMaster> godownMasterCreate = godownMasterRepository.findAll();


        return godownMasterCreate.stream().map(GodownMasterMapper::mapToGodownMasterDto).toList();

    }


    @Override
    public GodownMasterDto updateGodown(String godownCode, GodownMasterDto updatedGodown){
        GodownMaster godownMaster = godownMasterRepository.findById(godownCode).orElseThrow(()->
                new ResourceNotFoundException("Godown is not found with the given name:" + godownCode));


        godownMaster.setGodownCode(updatedGodown.getGodownCode());
        godownMaster.setGodownName(updatedGodown.getGodownName());

        GodownMaster godownMasterObj = godownMasterRepository.save(godownMaster);

        return GodownMasterMapper.mapToGodownMasterDto(godownMasterObj);
    }

    @Override
    public void deleteGodown(String godownCode){
        GodownMaster godownMaster = godownMasterRepository.findById(godownCode).orElseThrow(()->

                new ResourceNotFoundException("Godown is not exists with the given name:" + godownCode));

        godownMasterRepository.deleteById(godownCode);
    }
}
