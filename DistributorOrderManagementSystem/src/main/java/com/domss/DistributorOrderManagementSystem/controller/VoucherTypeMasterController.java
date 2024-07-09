package com.example.imperio.controller;

import com.example.imperio.dto.VoucherTypeMasterCreateDto;
import com.example.imperio.service.VoucherTypeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("voucherTypeMasterApi")
public class VoucherTypeMasterController {

    @Autowired
    private VoucherTypeMasterService voucherTypeMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addVoucherTypeMaster")
    public ResponseEntity<VoucherTypeMasterCreateDto> createVoucher(@RequestBody VoucherTypeMasterCreateDto voucherTypeMasterCreateDto){

        VoucherTypeMasterCreateDto saveVoucher = voucherTypeMasterService.createVoucherTypeMaster(voucherTypeMasterCreateDto);

        return new ResponseEntity<>(saveVoucher, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayVoucher/{voucherTypeName}")
    public ResponseEntity<VoucherTypeMasterCreateDto> getDataByVoucherTypeName(@PathVariable String voucherTypeName){

        VoucherTypeMasterCreateDto voucherTypeMasterCreateDto = voucherTypeMasterService.getVoucherTypeName(voucherTypeName);

        return ResponseEntity.ok(voucherTypeMasterCreateDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("/allVouchers")
    public ResponseEntity<List<VoucherTypeMasterCreateDto>> getAllVoucher(@PathVariable String voucherTypeName){

        List<VoucherTypeMasterCreateDto> allVouchers = voucherTypeMasterService.getAllVoucherTypeMasters();

        return ResponseEntity.ok(allVouchers);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterVoucherTypeMaster/{voucherTypeName}")
    public ResponseEntity<VoucherTypeMasterCreateDto> updateVoucher(@PathVariable String voucherTypeName, @RequestBody VoucherTypeMasterCreateDto updatedVoucher){

        VoucherTypeMasterCreateDto voucherTypeMasterCreateDto = voucherTypeMasterService.updateVoucherTypeMaster(voucherTypeName,updatedVoucher);

        return ResponseEntity.ok(voucherTypeMasterCreateDto);

    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteVoucher/{voucherTypeName}")
    public ResponseEntity<String> deleteVoucher(@PathVariable String voucherTypeName){

        voucherTypeMasterService.deleteVoucherTypeMaster(voucherTypeName);

        return ResponseEntity.ok("Voucher deleted successfully!");

    }
}
