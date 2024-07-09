package com.example.imperio.service;

import com.example.imperio.dto.ExecutiveMasterCreateDto;

import java.util.List;

public interface ExecutiveMasterService {

    ExecutiveMasterCreateDto createExecutiveMaster(ExecutiveMasterCreateDto executiveMasterCreateDto);

    ExecutiveMasterCreateDto getExecutiveMaster(String executiveCode);

    List<ExecutiveMasterCreateDto> getAllExecutiveMasterCodes();

    ExecutiveMasterCreateDto updateExecutive(String executiveCode, ExecutiveMasterCreateDto updatedExecutive);

    void deleteExecutive(String executiveCode);
}
