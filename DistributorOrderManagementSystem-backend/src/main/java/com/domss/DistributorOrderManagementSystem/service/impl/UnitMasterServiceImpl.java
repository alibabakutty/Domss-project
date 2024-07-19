package com.domss.DistributorOrderManagementSystem.service.impl;

import com.domss.DistributorOrderManagementSystem.dto.UnitMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.UnitMaster;
import com.domss.DistributorOrderManagementSystem.exception.ResourceNotFoundException;
import com.domss.DistributorOrderManagementSystem.mapper.UnitMasterMapper;
import com.domss.DistributorOrderManagementSystem.repository.UnitMasterRepository;
import com.domss.DistributorOrderManagementSystem.service.UnitMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnitMasterServiceImpl implements UnitMasterService {

    @Autowired
    private UnitMasterRepository unitMasterRepository;

    @Override
    public UnitMasterDto createUnitMaster(UnitMasterDto unitMasterDto){

        // validate the unit object
        validateUnitMaster(unitMasterDto);

        // check for duplicate entry
        if(unitMasterRepository.existsByProductUom(unitMasterDto.getProductUom())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + unitMasterDto.getProductUom());
        }

        UnitMaster unitMaster = UnitMasterMapper.mapToUnitMaster(unitMasterDto);

        UnitMaster savedUnitMaster = unitMasterRepository.save(unitMaster);

        return UnitMasterMapper.mapToUnitMasterDto(savedUnitMaster);


    }

    private void validateUnitMaster(UnitMasterDto unitMasterDto){
        if(unitMasterDto.getProductUom() == null || unitMasterDto.getProductUom().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty!");
        }
    }

    @Override
    public UnitMasterDto getUnitMaster(String productUom){
        UnitMaster unitMaster = unitMasterRepository.findByProductUom(productUom).orElseThrow(()->

                new ResourceNotFoundException("Unit is not found with this name:" + productUom));

        return UnitMasterMapper.mapToUnitMasterDto(unitMaster);


    }

    @Override
    public List<UnitMasterDto> getAllUnits(){

        List<UnitMaster> unitMaster = unitMasterRepository.findAll();

        return unitMaster.stream().map(UnitMasterMapper::mapToUnitMasterDto).toList();

    }

    @Override
    public void deleteUnit(String uom){

        UnitMaster unitMaster = unitMasterRepository.findByProductUom(uom).orElseThrow(()->

                new ResourceNotFoundException("Units is not found with this name:" + uom));

        unitMasterRepository.deleteById(Long.valueOf(uom));

    }
}
