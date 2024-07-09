package com.domss.DistributorOrderManagementSystem.controller;


import com.domss.DistributorOrderManagementSystem.dto.VoucherTypeMasterDto;
import com.domss.DistributorOrderManagementSystem.service.VoucherTypeMasterService;
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
    public ResponseEntity<VoucherTypeMasterDto> createVoucher(@RequestBody VoucherTypeMasterDto voucherTypeMasterDto){

        VoucherTypeMasterDto saveVoucher = voucherTypeMasterService.createVoucherTypeMaster(voucherTypeMasterDto);

        return new ResponseEntity<>(saveVoucher, HttpStatus.CREATED);

    }

    //Build GET Master Ids REST API
    @GetMapping("/displayVoucher/{voucherTypeName}")
    public ResponseEntity<VoucherTypeMasterDto> getDataByVoucherTypeName(@PathVariable String voucherTypeName){

        VoucherTypeMasterDto voucherTypeMasterDto = voucherTypeMasterService.getVoucherTypeName(voucherTypeName);

        return ResponseEntity.ok(voucherTypeMasterDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("/allVouchers")
    public ResponseEntity<List<VoucherTypeMasterDto>> getAllVoucher(@PathVariable String voucherTypeName){

        List<VoucherTypeMasterDto> allVouchers = voucherTypeMasterService.getAllVoucherTypeMasters();

        return ResponseEntity.ok(allVouchers);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterVoucherTypeMaster/{voucherTypeName}")
    public ResponseEntity<VoucherTypeMasterDto> updateVoucher(@PathVariable String voucherTypeName, @RequestBody VoucherTypeMasterDto updatedVoucher){

        VoucherTypeMasterDto voucherTypeMasterDto = voucherTypeMasterService.updateVoucherTypeMaster(voucherTypeName,updatedVoucher);

        return ResponseEntity.ok(voucherTypeMasterDto);

    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteVoucher/{voucherTypeName}")
    public ResponseEntity<String> deleteVoucher(@PathVariable String voucherTypeName){

        voucherTypeMasterService.deleteVoucherTypeMaster(voucherTypeName);

        return ResponseEntity.ok("Voucher deleted successfully!");

    }
}
