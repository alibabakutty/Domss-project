package com.example.imperio.service.impl;

import com.example.imperio.dto.UnitMasterCreateDto;
import com.example.imperio.entity.UnitMasterCreate;
import com.example.imperio.exception.ResourceNotFoundException;
import com.example.imperio.mapper.UnitMasterCreateMapper;
import com.example.imperio.repository.UnitMasterDAO;
import com.example.imperio.service.UnitMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnitMasterServiceImpl implements UnitMasterService {

    @Autowired
    private UnitMasterDAO unitMasterDAO;

    @Override
    public UnitMasterCreateDto createUnitMaster(UnitMasterCreateDto unitMasterCreateDto){

        // validate the unit object
        validateUnitMaster(unitMasterCreateDto);

        // check for duplicate entry
        if(unitMasterDAO.existsByProductUom(unitMasterCreateDto.getProductUom())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + unitMasterCreateDto.getProductUom());
        }

        UnitMasterCreate unitMasterCreate = UnitMasterCreateMapper.mapToUnitMasterCreate(unitMasterCreateDto);

        UnitMasterCreate savedUnitMaster = unitMasterDAO.save(unitMasterCreate);

        return UnitMasterCreateMapper.mapToUnitMasterCreateDto(savedUnitMaster);


    }

    private void validateUnitMaster(UnitMasterCreateDto unitMasterCreateDto){
        if(unitMasterCreateDto.getProductUom() == null || unitMasterCreateDto.getProductUom().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty!");
        }
    }

    @Override
    public UnitMasterCreateDto getUnitMaster(String productUom){
        UnitMasterCreate unitMasterCreate = unitMasterDAO.findById(productUom).orElseThrow(()->

                new ResourceNotFoundException("Unit is not found with this name:" + productUom));

        return UnitMasterCreateMapper.mapToUnitMasterCreateDto(unitMasterCreate);


    }

    @Override
    public List<UnitMasterCreateDto> getAllUnits(){

        List<UnitMasterCreate> unitMasterCreate = unitMasterDAO.findAll();

        return unitMasterCreate.stream().map(UnitMasterCreateMapper::mapToUnitMasterCreateDto).toList();

    }

    @Override
    public void deleteUnit(String uom){

        UnitMasterCreate unitMasterCreate = unitMasterDAO.findById(uom).orElseThrow(()->

                new ResourceNotFoundException("Units is not found with this name:" + uom));

        unitMasterDAO.deleteById(uom);

    }
}
