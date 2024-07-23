package com.domss.DistributorOrderManagementSystem.controller;

import com.domss.DistributorOrderManagementSystem.entity.VoucherConfig;
import com.domss.DistributorOrderManagementSystem.repository.VoucherConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("generate")
public class VoucherConfigController {

    @Autowired
    private VoucherConfigRepository voucherConfigRepository;

    @PostMapping("saveVoucher")
    public ResponseEntity<VoucherConfig> saveVoucher(@RequestBody VoucherConfig config){
        return new ResponseEntity<>(voucherConfigRepository.save(config), HttpStatus.CREATED);
    }

    @GetMapping("currentVoucher")
    public ResponseEntity<String> currentVoucher(){
        VoucherConfig voucher = voucherConfigRepository.findById(1L).orElse(null);
        int startingNo = voucher.getStartingNumber();
        String prefix = voucher.getPrefix();
        String suffix = voucher.getSuffix();
        int widthOfNumerical = voucher.getWidthOfNumerical();

        String currentNo = String.format("%0" + widthOfNumerical + "d", startingNo);

        return new ResponseEntity<>(String.format("%s-%s%s",prefix, currentNo, suffix != null ? "-" + suffix : ""), HttpStatus.OK);
    }

    @GetMapping("incrementVoucher")
    public ResponseEntity<String> incrementVoucher(){
        VoucherConfig voucher = voucherConfigRepository.findById(1L).orElse(null);
        if(voucher != null){
            int nextNumber = voucher.getStartingNumber() + 1;
            voucher.setStartingNumber(nextNumber);
            voucherConfigRepository.save(voucher);
            return new ResponseEntity<>(String.valueOf(nextNumber), HttpStatus.OK);
        }
        return new ResponseEntity<>("Error making next voucher create", HttpStatus.BAD_REQUEST);
    }

}
