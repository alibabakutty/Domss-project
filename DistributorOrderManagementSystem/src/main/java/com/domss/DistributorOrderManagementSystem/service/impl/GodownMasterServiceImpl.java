package com.example.imperio.service.impl;

import com.example.imperio.dto.GodownMasterCreateDto;
import com.example.imperio.entity.GodownMasterCreate;
import com.example.imperio.exception.ResourceNotFoundException;
import com.example.imperio.mapper.GodownMasterCreateMapper;
import com.example.imperio.repository.GodownMasterCreateDAO;
import com.example.imperio.service.GodownMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GodownMasterServiceImpl implements GodownMasterService {

    @Autowired
    private GodownMasterCreateDAO godownMasterCreateDAO;

    @Override
    public GodownMasterCreateDto createGodownMaster(GodownMasterCreateDto godownMasterCreateDto){

        // validate the godown object
        validateGodownMaster(godownMasterCreateDto);

        // check for duplicate entry
        if(godownMasterCreateDAO.existsByGodownCode(godownMasterCreateDto.getGodownCode())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + godownMasterCreateDto.getGodownCode());
        }


        GodownMasterCreate godownMasterCreate = GodownMasterCreateMapper.mapToGodownMasterCreate(godownMasterCreateDto);

        GodownMasterCreate savedGodownMasterCreate = godownMasterCreateDAO.save(godownMasterCreate);

        return GodownMasterCreateMapper.mapToGodownMasterCreateDto(savedGodownMasterCreate);

    }

    private void validateGodownMaster(GodownMasterCreateDto godownMasterCreateDto){
        if(godownMasterCreateDto.getGodownCode() == null || godownMasterCreateDto.getGodownCode().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty");
        }
    }

    @Override
    public GodownMasterCreateDto getGodownMaster(String godownCode){
        GodownMasterCreate godownMasterCreate = godownMasterCreateDAO.findById(godownCode).orElseThrow(()->

                new ResourceNotFoundException("Godown is not found with this name:" + godownCode));

        return GodownMasterCreateMapper.mapToGodownMasterCreateDto(godownMasterCreate);

    }


    @Override
    public List<GodownMasterCreateDto> getAllGodownMasterCodes(){

        List<GodownMasterCreate> godownMasterCreate = godownMasterCreateDAO.findAll();


        return godownMasterCreate.stream().map(GodownMasterCreateMapper::mapToGodownMasterCreateDto).toList();

    }


    @Override
    public  GodownMasterCreateDto updateGodown(String godownCode, GodownMasterCreateDto updatedGodown){
        GodownMasterCreate godownMasterCreate = godownMasterCreateDAO.findById(godownCode).orElseThrow(()->
                new ResourceNotFoundException("Godown is not found with the given name:" + godownCode));


        godownMasterCreate.setGodownCode(updatedGodown.getGodownCode());
        godownMasterCreate.setGodownName(updatedGodown.getGodownName());

        GodownMasterCreate godownMasterCreateObj = godownMasterCreateDAO.save(godownMasterCreate);

        return GodownMasterCreateMapper.mapToGodownMasterCreateDto(godownMasterCreateObj);
    }

    @Override
    public void deleteGodown(String godownCode){
        GodownMasterCreate godownMasterCreate = godownMasterCreateDAO.findById(godownCode).orElseThrow(()->

                new ResourceNotFoundException("Godown is not exists with the given name:" + godownCode));

        godownMasterCreateDAO.deleteById(godownCode);
    }
}
