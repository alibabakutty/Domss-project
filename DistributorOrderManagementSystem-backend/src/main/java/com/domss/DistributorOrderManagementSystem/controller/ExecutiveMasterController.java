package com.domss.DistributorOrderManagementSystem.controller;

import com.domss.DistributorOrderManagementSystem.dto.ExecutiveMasterDto;
import com.domss.DistributorOrderManagementSystem.service.ExecutiveMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/executiveMasterApi")
public class ExecutiveMasterController {

    @Autowired
    private ExecutiveMasterService executiveMasterService;


    //Build ADD Masters REST API
    @PostMapping("/addExecutive")
    public ResponseEntity<ExecutiveMasterDto> createExecutiveMaster(@RequestBody ExecutiveMasterDto executiveMasterDto){

        ExecutiveMasterDto saveExecutiveMaster = executiveMasterService.createExecutiveMaster(executiveMasterDto);

        return new ResponseEntity<>(saveExecutiveMaster, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayExecutive/{executiveCode}")
    public ResponseEntity<ExecutiveMasterDto> getDataByExecutiveCode(@PathVariable String executiveCode){

        ExecutiveMasterDto executiveMasterDto = executiveMasterService.getExecutiveMaster(executiveCode);

        return ResponseEntity.ok(executiveMasterDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("/allExecutives")
    public ResponseEntity<List<ExecutiveMasterDto>> getAllExecutives(){
        List<ExecutiveMasterDto> allExecutives = executiveMasterService.getAllExecutiveMasterCodes();

        return ResponseEntity.ok(allExecutives);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterExecutiveMaster/{executiveCode}")
    public ResponseEntity<ExecutiveMasterDto> updateExecutive(@PathVariable String executiveCode, @RequestBody ExecutiveMasterDto updatedExecutives){

        ExecutiveMasterDto executiveMasterDto = executiveMasterService.updateExecutive(executiveCode,updatedExecutives);

        return ResponseEntity.ok(executiveMasterDto);
    }

    //Build DELETE REST API
    @DeleteMapping("deleteExecutive/{executiveCode}")
    public ResponseEntity<String> deleteExecutive(@PathVariable String executiveCode){

        executiveMasterService.deleteExecutive(executiveCode);

        return ResponseEntity.ok("Executive deleted successfully!");

    }
}
