package com.domss.DistributorOrderManagementSystem.controller;

import com.domss.DistributorOrderManagementSystem.dto.UnitMasterDto;
import com.domss.DistributorOrderManagementSystem.service.UnitMasterService;
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
    public ResponseEntity<UnitMasterDto> createUnitMaster(@RequestBody UnitMasterDto unitMasterDto){

        UnitMasterDto saveUnitMaster = unitMasterService.createUnitMaster(unitMasterDto);

        return new ResponseEntity<>(saveUnitMaster, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayUnit/{productUom}")
    public ResponseEntity<UnitMasterDto> getDataByUnitCode(@PathVariable String productUom){

        UnitMasterDto unitMasterDto = unitMasterService.getUnitMaster(productUom);

        return ResponseEntity.ok(unitMasterDto);

    }


    //Build GET All Master Ids REST API
    @GetMapping("/allUnits")
    public ResponseEntity<List<UnitMasterDto>> getAllUnits(){

        List<UnitMasterDto> allUnits = unitMasterService.getAllUnits();

        return ResponseEntity.ok(allUnits);

    }

    //Build DELETE Ledger REST API
    @GetMapping("deleteUnit/{productUom}")
    public ResponseEntity<String> deleteUnit(@PathVariable String productUom){

        unitMasterService.deleteUnit(productUom);

        return ResponseEntity.ok("Unit deleted successfully!");

    }
}
