package com.example.imperio.mapper;


import com.example.imperio.dto.UnitMasterCreateDto;
import com.example.imperio.entity.UnitMasterCreate;

public class UnitMasterCreateMapper {

    public static UnitMasterCreateDto mapToUnitMasterCreateDto(UnitMasterCreate unitMasterCreate){
        return new UnitMasterCreateDto(
                unitMasterCreate.getProductUom()
        );
    }

    public static UnitMasterCreate mapToUnitMasterCreate(UnitMasterCreateDto unitMasterCreateDto){
        return new UnitMasterCreate(
                unitMasterCreateDto.getProductUom()
        );
    }
}
