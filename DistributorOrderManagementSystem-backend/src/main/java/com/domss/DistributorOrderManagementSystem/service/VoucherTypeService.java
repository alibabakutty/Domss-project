package com.domss.DistributorOrderManagementSystem.service;

import com.domss.DistributorOrderManagementSystem.dto.VoucherTypeDto;

import java.util.List;

public interface VoucherTypeService {
    VoucherTypeDto createVoucherType(VoucherTypeDto voucherTypeDto);

    VoucherTypeDto getVoucherType(String voucherType);

    List<VoucherTypeDto> getAllVoucherTypes();

    void deleteVoucherType(String voucherType);
}
