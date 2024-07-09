package com.domss.DistributorOrderManagementSystem.controller;

import com.domss.DistributorOrderManagementSystem.dto.GodownMasterDto;
import com.domss.DistributorOrderManagementSystem.service.GodownMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/godownMasterApi")
public class GodownMasterController {

    @Autowired
    private GodownMasterService godownMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addGodown")
    public ResponseEntity<GodownMasterDto> createGodownMaster(@RequestBody GodownMasterDto godownMasterDto){

        GodownMasterDto saveGodownMaster = godownMasterService.createGodownMaster(godownMasterDto);

        return new ResponseEntity<>(saveGodownMaster, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayGodown/{godownCode}")
    public ResponseEntity<GodownMasterDto> getDataByGodownCode(@PathVariable String godownCode){

        GodownMasterDto godownMasterDto = godownMasterService.getGodownMaster(godownCode);

        return ResponseEntity.ok(godownMasterDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("/allGodowns")
    public ResponseEntity<List<GodownMasterDto>> getAllGodowns(){

        List<GodownMasterDto> allGodowns = godownMasterService.getAllGodownMasterCodes();

        return ResponseEntity.ok(allGodowns);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterGodownMaster/{godownCode}")
    public ResponseEntity<GodownMasterDto> updateGodown(@PathVariable String godownCode, @RequestBody GodownMasterDto updatedGodown){

        GodownMasterDto godownMasterDto = godownMasterService.updateGodown(godownCode,updatedGodown);

        return ResponseEntity.ok(godownMasterDto);

    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteGodown/{godownCode}")
    public ResponseEntity<String> deleteGodown(@PathVariable String godownCode){

        godownMasterService.deleteGodown(godownCode);

        return ResponseEntity.ok("Godown deleted successfully!");

    }
}
