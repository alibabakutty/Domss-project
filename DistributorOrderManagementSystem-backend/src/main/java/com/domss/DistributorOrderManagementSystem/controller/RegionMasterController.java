package com.domss.DistributorOrderManagementSystem.controller;

import com.domss.DistributorOrderManagementSystem.dto.RegionMasterDto;
import com.domss.DistributorOrderManagementSystem.service.RegionMasterService;

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
    public ResponseEntity<RegionMasterDto> createRegionMaster(@RequestBody RegionMasterDto regionMasterDto){

        RegionMasterDto saveRegionMaster = regionMasterService.createRegionMaster(regionMasterDto);

        return new ResponseEntity<>(saveRegionMaster, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("displayRegion/{regionMasterId}")
    public ResponseEntity<RegionMasterDto> getDataByRegionCode(@PathVariable String regionMasterId){

        RegionMasterDto regionMasterDto = regionMasterService.getRegionMaster(regionMasterId);

        return ResponseEntity.ok(regionMasterDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("allRegions")
    public ResponseEntity<List<RegionMasterDto>> getAllRegions(){

        List<RegionMasterDto> allRegions = regionMasterService.getAllRegionMasterIds();

        return ResponseEntity.ok(allRegions);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterRegionMaster/{regionMasterId}")
    public ResponseEntity<RegionMasterDto> updateRegion(@PathVariable String regionMasterId, @RequestBody RegionMasterDto updatedRegion){

        RegionMasterDto regionMasterDto = regionMasterService.updateRegion(regionMasterId,updatedRegion);

        return ResponseEntity.ok(regionMasterDto);

    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteRegion/{regionMasterId}")
    public ResponseEntity<String> deleteRegion(@PathVariable String regionMasterId){

        regionMasterService.deleteRegion(regionMasterId);

        return ResponseEntity.ok("Region deleted successfully!");

    }
}
