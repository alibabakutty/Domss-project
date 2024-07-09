package com.example.imperio.service;

import com.example.imperio.dto.VoucherTypeMasterCreateDto;

import java.util.List;

public interface VoucherTypeMasterService {
    VoucherTypeMasterCreateDto createVoucherTypeMaster(VoucherTypeMasterCreateDto voucherTypeMasterCreateDto);

    VoucherTypeMasterCreateDto getVoucherTypeName(String voucherTypeName);

    List<VoucherTypeMasterCreateDto> getAllVoucherTypeMasters();

    VoucherTypeMasterCreateDto updateVoucherTypeMaster(String voucherTypeName, VoucherTypeMasterCreateDto updatedVoucherTypeMaster);

    void deleteVoucherTypeMaster(String voucherTypeName);
}
