package com.example.imperio.controller;

import com.example.imperio.dto.RegionMasterCreateDto;
import com.example.imperio.service.RegionMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/regionMasterApi")
public class RegionMasterController {

    @Autowired
    private RegionMasterService regionMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addRegion")
    public ResponseEntity<RegionMasterCreateDto> createRegionMaster(@RequestBody RegionMasterCreateDto regionMasterCreateDto){

        RegionMasterCreateDto saveRegionMaster = regionMasterService.createRegionMaster(regionMasterCreateDto);

        return new ResponseEntity<>(saveRegionMaster, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("displayRegion/{regionMasterId}")
    public ResponseEntity<RegionMasterCreateDto> getDataByRegionCode(@PathVariable String regionMasterId){

        RegionMasterCreateDto regionMasterCreateDto = regionMasterService.getRegionMaster(regionMasterId);

        return ResponseEntity.ok(regionMasterCreateDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("allRegions")
    public ResponseEntity<List<RegionMasterCreateDto>> getAllRegions(){

        List<RegionMasterCreateDto> allRegions = regionMasterService.getAllRegionMasterIds();

        return ResponseEntity.ok(allRegions);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterRegionMaster/{regionMasterId}")
    public ResponseEntity<RegionMasterCreateDto> updateRegion(@PathVariable String regionMasterId, @RequestBody RegionMasterCreateDto updatedRegion){

        RegionMasterCreateDto regionMasterCreateDto = regionMasterService.updateRegion(regionMasterId,updatedRegion);

        return ResponseEntity.ok(regionMasterCreateDto);

    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteRegion/{regionMasterId}")
    public ResponseEntity<String> deleteRegion(@PathVariable String regionMasterId){

        regionMasterService.deleteRegion(regionMasterId);

        return ResponseEntity.ok("Region deleted successfully!");

    }
}
