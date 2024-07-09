package com.example.imperio.service;

import com.example.imperio.dto.GodownMasterCreateDto;

import java.util.List;

public interface GodownMasterService {
    GodownMasterCreateDto createGodownMaster(GodownMasterCreateDto godownMasterCreateDto);

    GodownMasterCreateDto getGodownMaster(String godownCode);

    List<GodownMasterCreateDto> getAllGodownMasterCodes();

    GodownMasterCreateDto updateGodown(String godownCode, GodownMasterCreateDto updatedGodown);

    void deleteGodown(String godownCode);
}
