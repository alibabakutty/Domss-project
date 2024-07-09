package com.domss.DistributorOrderManagementSystem.controller;


import com.domss.DistributorOrderManagementSystem.dto.DistributorMasterDto;
import com.domss.DistributorOrderManagementSystem.service.DistributorMasterService;
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
    public ResponseEntity<DistributorMasterDto> createDistributorEntity(@RequestBody DistributorMasterDto distributorMasterDto){



        return distributorMasterService.createDistributorMaster(distributorMasterDto);
    }

    //Build GET Master Ids REST API
    @GetMapping("/displayDistributor/{distributorCode}")
    public ResponseEntity<DistributorMasterDto> getDataByDistributorCode(@PathVariable String distributorCode){

        DistributorMasterDto distributorMasterDto = distributorMasterService.getDistributorMaster(distributorCode);

        return ResponseEntity.ok(distributorMasterDto);
    }

    //Build GET All Master Ids REST API
    @GetMapping("/allDistributors")
    public ResponseEntity<List<DistributorMasterDto>> getAllDistributors(){

        List<DistributorMasterDto> allDistributors = distributorMasterService.getAllDistributors();

        return ResponseEntity.ok(allDistributors);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterDistributorMaster/{distributorCode}")
    public ResponseEntity<DistributorMasterDto> updateDistributor(@PathVariable String distributorCode, @RequestBody DistributorMasterDto updatedDistributor){

        DistributorMasterDto distributorMasterDto = distributorMasterService.updateDistributor(distributorCode, updatedDistributor);

        return ResponseEntity.ok(distributorMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteDistributor/{distributorCode}")
    public ResponseEntity<String> deleteDistributor(@PathVariable String distributorCode){

        distributorMasterService.deleteDistributor(distributorCode);

        return ResponseEntity.ok("Distributor deleted successfully!");
    }
}
