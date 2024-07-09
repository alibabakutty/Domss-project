package com.example.imperio.controller;


import com.example.imperio.dto.DistributorMasterCreateDto;
import com.example.imperio.service.DistributorMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/distributorMasterApi")
public class DistributorMasterController {

    @Autowired
    private DistributorMasterService distributorMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addDistributor")
    public ResponseEntity<DistributorMasterCreateDto> createDistributorEntity(@RequestBody DistributorMasterCreateDto distributorMasterCreateDto){

        DistributorMasterCreateDto saveDistributorMaster = distributorMasterService.createDistributorMaster(distributorMasterCreateDto);

        return new ResponseEntity<>(saveDistributorMaster, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @GetMapping("/displayDistributor/{distributorCode}")
    public ResponseEntity<DistributorMasterCreateDto> getDataByDistributorCode(@PathVariable String distributorCode){

        DistributorMasterCreateDto distributorMasterCreateDto = distributorMasterService.getDistributorMaster(distributorCode);

        return ResponseEntity.ok(distributorMasterCreateDto);
    }

    //Build GET All Master Ids REST API
    @GetMapping("/allDistributors")
    public ResponseEntity<List<DistributorMasterCreateDto>> getAllDistributors(){

        List<DistributorMasterCreateDto> allDistributors = distributorMasterService.getAllDistributors();

        return ResponseEntity.ok(allDistributors);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterDistributorMaster/{distributorCode}")
    public ResponseEntity<DistributorMasterCreateDto> updateDistributor(@PathVariable String distributorCode, @RequestBody DistributorMasterCreateDto updatedDistributor){

        DistributorMasterCreateDto distributorMasterCreateDto = distributorMasterService.updateDistributor(distributorCode,updatedDistributor);

        return ResponseEntity.ok(distributorMasterCreateDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteDistributor/{distributorCode}")
    public ResponseEntity<String> deleteDistributor(@PathVariable String distributorCode){

        distributorMasterService.deleteDistributor(distributorCode);

        return ResponseEntity.ok("Distributor deleted successfully!");
    }
}
