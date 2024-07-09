package com.domss.DistributorOrderManagementSystem.service;

import com.domss.DistributorOrderManagementSystem.dto.VoucherTypeMasterDto;

import java.util.List;

public interface VoucherTypeMasterService {
    VoucherTypeMasterDto createVoucherTypeMaster(VoucherTypeMasterDto voucherTypeMasterDto);

    VoucherTypeMasterDto getVoucherTypeName(String voucherTypeName);

    List<VoucherTypeMasterDto> getAllVoucherTypeMasters();

    VoucherTypeMasterDto updateVoucherTypeMaster(String voucherTypeName, VoucherTypeMasterDto updatedVoucherTypeMaster);

    void deleteVoucherTypeMaster(String voucherTypeName);
}
