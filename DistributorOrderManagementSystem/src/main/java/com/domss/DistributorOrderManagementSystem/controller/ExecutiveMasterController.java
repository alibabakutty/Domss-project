package com.example.imperio.controller;

import com.example.imperio.dto.ExecutiveMasterCreateDto;
import com.example.imperio.service.ExecutiveMasterService;
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
    public ResponseEntity<ExecutiveMasterCreateDto> createExecutiveMaster(@RequestBody ExecutiveMasterCreateDto executiveMasterCreateDto){

        ExecutiveMasterCreateDto saveExecutiveMaster = executiveMasterService.createExecutiveMaster(executiveMasterCreateDto);

        return new ResponseEntity<>(saveExecutiveMaster, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayExecutive/{executiveCode}")
    public ResponseEntity<ExecutiveMasterCreateDto> getDataByExecutiveCode(@PathVariable String executiveCode){

        ExecutiveMasterCreateDto executiveMasterCreateDto = executiveMasterService.getExecutiveMaster(executiveCode);

        return ResponseEntity.ok(executiveMasterCreateDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("/allExecutives")
    public ResponseEntity<List<ExecutiveMasterCreateDto>> getAllExecutives(){
        List<ExecutiveMasterCreateDto> allExecutives = executiveMasterService.getAllExecutiveMasterCodes();

        return ResponseEntity.ok(allExecutives);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterExecutiveMaster/{executiveCode}")
    public ResponseEntity<ExecutiveMasterCreateDto> updateExecutive(@PathVariable String executiveCode, @RequestBody ExecutiveMasterCreateDto updatedExecutives){

        ExecutiveMasterCreateDto executiveMasterCreateDto = executiveMasterService.updateExecutive(executiveCode,updatedExecutives);

        return ResponseEntity.ok(executiveMasterCreateDto);
    }

    //Build DELETE REST API
    @DeleteMapping("deleteExecutive/{executiveCode}")
    public ResponseEntity<String> deleteExecutive(@PathVariable String executiveCode){

        executiveMasterService.deleteExecutive(executiveCode);

        return ResponseEntity.ok("Executive deleted successfully!");

    }
}
