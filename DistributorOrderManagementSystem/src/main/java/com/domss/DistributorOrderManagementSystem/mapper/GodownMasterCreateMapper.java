package com.example.imperio.mapper;

import com.example.imperio.dto.GodownMasterCreateDto;
import com.example.imperio.entity.GodownMasterCreate;

public class GodownMasterCreateMapper {


    public static GodownMasterCreateDto mapToGodownMasterCreateDto(GodownMasterCreate godownMasterCreate){
        return new GodownMasterCreateDto(
                godownMasterCreate.getGodownCode(),
                godownMasterCreate.getGodownName()
        );
    }


    public static GodownMasterCreate mapToGodownMasterCreate(GodownMasterCreateDto godownMasterCreateDto){
        return new GodownMasterCreate(
                godownMasterCreateDto.getGodownCode(),
                godownMasterCreateDto.getGodownName()
        );
    }
}
