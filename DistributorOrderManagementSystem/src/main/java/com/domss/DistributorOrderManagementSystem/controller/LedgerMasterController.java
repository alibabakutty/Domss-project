package com.example.imperio.controller;

import com.example.imperio.dto.LedgerMasterCreateDto;
import com.example.imperio.service.LedgerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/ledgerMasterApi")
public class LedgerMasterController {

    @Autowired
    private LedgerMasterService ledgerMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addLedgerMaster")
    public ResponseEntity<LedgerMasterCreateDto> createLedgerMaster(@RequestBody LedgerMasterCreateDto ledgerMasterCreateDto){

        LedgerMasterCreateDto saveLedgerMaster = ledgerMasterService.createLedgerMaster(ledgerMasterCreateDto);

        return new ResponseEntity<>(saveLedgerMaster, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("displayLedger/{ledgerCode}")
    public ResponseEntity<LedgerMasterCreateDto> getDataByLedger(@PathVariable String ledgerCode){

        LedgerMasterCreateDto ledgerMasterCreateDto = ledgerMasterService.getLedgerCode(ledgerCode);

        return ResponseEntity.ok(ledgerMasterCreateDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("/allLedgers")
    public ResponseEntity<List<LedgerMasterCreateDto>> getAllLedgers(){

        List<LedgerMasterCreateDto> allLedgers = ledgerMasterService.getAllLedgerCodes();

        return ResponseEntity.ok(allLedgers);

    }


    //Build UPDATE Master REST API

    @PutMapping("/alterLedgerMaster/{ledgerCode}")
    public ResponseEntity<LedgerMasterCreateDto> updateLedger(@PathVariable String ledgerCode, @RequestBody LedgerMasterCreateDto updatedLedger){

        LedgerMasterCreateDto ledgerMasterCreateDto = ledgerMasterService.updateLedgerMaster(ledgerCode,updatedLedger);

        return ResponseEntity.ok(ledgerMasterCreateDto);

    }


    //Build DELETE Ledger REST API

    @DeleteMapping("deleteLedger/{ledgerCode}")
    public ResponseEntity<String> deleteLedger(@PathVariable String ledgerCode){

        ledgerMasterService.deleteLedgerMaster(ledgerCode);

        return ResponseEntity.ok("Ledger is deleted successfully!");

    }
}
