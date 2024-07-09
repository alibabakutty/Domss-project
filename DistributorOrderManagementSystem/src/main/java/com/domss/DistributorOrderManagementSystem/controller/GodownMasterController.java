package com.example.imperio.controller;

import com.example.imperio.dto.GodownMasterCreateDto;
import com.example.imperio.service.GodownMasterService;
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
    public ResponseEntity<GodownMasterCreateDto> createGodownMaster(@RequestBody GodownMasterCreateDto godownMasterCreateDto){

        GodownMasterCreateDto saveGodownMaster = godownMasterService.createGodownMaster(godownMasterCreateDto);

        return new ResponseEntity<>(saveGodownMaster, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayGodown/{godownCode}")
    public ResponseEntity<GodownMasterCreateDto> getDataByGodownCode(@PathVariable String godownCode){

        GodownMasterCreateDto godownMasterCreateDto = godownMasterService.getGodownMaster(godownCode);

        return ResponseEntity.ok(godownMasterCreateDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("/allGodowns")
    public ResponseEntity<List<GodownMasterCreateDto>> getAllGodowns(){

        List<GodownMasterCreateDto> allGodowns = godownMasterService.getAllGodownMasterCodes();

        return ResponseEntity.ok(allGodowns);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterGodownMaster/{godownCode}")
    public ResponseEntity<GodownMasterCreateDto> updateGodown(@PathVariable String godownCode, @RequestBody GodownMasterCreateDto updatedGodown){

        GodownMasterCreateDto godownMasterCreateDto = godownMasterService.updateGodown(godownCode,updatedGodown);

        return ResponseEntity.ok(godownMasterCreateDto);

    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteGodown/{godownCode}")
    public ResponseEntity<String> deleteGodown(@PathVariable String godownCode){

        godownMasterService.deleteGodown(godownCode);

        return ResponseEntity.ok("Godown deleted successfully!");

    }
}
