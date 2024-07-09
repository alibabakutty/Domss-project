package com.domss.DistributorOrderManagementSystem.controller;


import com.domss.DistributorOrderManagementSystem.dto.VoucherTypeDto;
import com.domss.DistributorOrderManagementSystem.service.VoucherTypeService;
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
    public ResponseEntity<VoucherTypeDto> createVoucherType(@RequestBody VoucherTypeDto voucherTypeDto){

        VoucherTypeDto saveVoucherType = voucherTypeService.createVoucherType(voucherTypeDto);

        return new ResponseEntity<>(saveVoucherType, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayVoucherType/{voucherType}")
    public ResponseEntity<VoucherTypeDto> getDataByVoucherType(@PathVariable String voucherType){

        VoucherTypeDto voucherTypeDto = voucherTypeService.getVoucherType(voucherType);

        return ResponseEntity.ok(voucherTypeDto);

    }


    //Build GET All Master Ids REST API
    @GetMapping("allVoucherTypes")
    public ResponseEntity<List<VoucherTypeDto>> getAllVoucherTypes(){

        List<VoucherTypeDto> allVoucherTypes = voucherTypeService.getAllVoucherTypes();

        return ResponseEntity.ok(allVoucherTypes);

    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteVoucherType/{voucherType}")
    public ResponseEntity<String> deleteVoucherType(@PathVariable String voucherType){

        voucherTypeService.deleteVoucherType(voucherType);

        return ResponseEntity.ok("Voucher Type deleted successfully!");

    }
}
