package com.example.imperio.controller;

import com.example.imperio.dto.VoucherTypeCreateDto;
import com.example.imperio.service.VoucherTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/voucherTypeApi")
public class VoucherTypeController {

    @Autowired
    private VoucherTypeService voucherTypeService;


    //Build ADD Masters REST API
    @PostMapping("/addVoucherType")
    public ResponseEntity<VoucherTypeCreateDto> createVoucherType(@RequestBody VoucherTypeCreateDto voucherTypeCreateDto){

        VoucherTypeCreateDto saveVoucherType = voucherTypeService.createVoucherType(voucherTypeCreateDto);

        return new ResponseEntity<>(saveVoucherType, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayVoucherType/{voucherType}")
    public ResponseEntity<VoucherTypeCreateDto> getDataByVoucherType(@PathVariable String voucherType){

        VoucherTypeCreateDto voucherTypeCreateDto = voucherTypeService.getVoucherType(voucherType);

        return ResponseEntity.ok(voucherTypeCreateDto);

    }


    //Build GET All Master Ids REST API
    @GetMapping("allVoucherTypes")
    public ResponseEntity<List<VoucherTypeCreateDto>> getAllVoucherTypes(){

        List<VoucherTypeCreateDto> allVoucherTypes = voucherTypeService.getAllVoucherTypes();

        return ResponseEntity.ok(allVoucherTypes);

    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteVoucherType/{voucherType}")
    public ResponseEntity<String> deleteVoucherType(@PathVariable String voucherType){

        voucherTypeService.deleteVoucherType(voucherType);

        return ResponseEntity.ok("Voucher Type deleted successfully!");

    }
}
