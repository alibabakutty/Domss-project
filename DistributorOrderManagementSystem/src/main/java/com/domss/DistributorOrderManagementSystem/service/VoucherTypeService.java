package com.example.imperio.service;

import com.example.imperio.dto.VoucherTypeCreateDto;

import java.util.List;

public interface VoucherTypeService {
    VoucherTypeCreateDto createVoucherType(VoucherTypeCreateDto voucherTypeCreateDto);

    VoucherTypeCreateDto getVoucherType(String voucherType);

    List<VoucherTypeCreateDto> getAllVoucherTypes();

    void deleteVoucherType(String voucherType);
}
