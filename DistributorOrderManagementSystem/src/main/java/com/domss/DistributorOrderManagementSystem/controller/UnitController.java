package com.example.imperio.controller;

import com.example.imperio.dto.UnitMasterCreateDto;
import com.example.imperio.service.UnitMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/unitMasterApi")
public class UnitController {

    @Autowired
    private UnitMasterService unitMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addUnit")
    public ResponseEntity<UnitMasterCreateDto> createUnitMaster(@RequestBody UnitMasterCreateDto unitMasterCreateDto){

        UnitMasterCreateDto saveUnitMaster = unitMasterService.createUnitMaster(unitMasterCreateDto);

        return new ResponseEntity<>(saveUnitMaster, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayUnit/{productUom}")
    public ResponseEntity<UnitMasterCreateDto> getDataByUnitCode(@PathVariable String productUom){

        UnitMasterCreateDto unitMasterCreateDto = unitMasterService.getUnitMaster(productUom);

        return ResponseEntity.ok(unitMasterCreateDto);

    }


    //Build GET All Master Ids REST API
    @GetMapping("/allUnits")
    public ResponseEntity<List<UnitMasterCreateDto>> getAllUnits(){

        List<UnitMasterCreateDto> allUnits = unitMasterService.getAllUnits();

        return ResponseEntity.ok(allUnits);

    }

    //Build DELETE Ledger REST API
    @GetMapping("deleteUnit/{productUom}")
    public ResponseEntity<String> deleteUnit(@PathVariable String productUom){

        unitMasterService.deleteUnit(productUom);

        return ResponseEntity.ok("Unit deleted successfully!");

    }
}
