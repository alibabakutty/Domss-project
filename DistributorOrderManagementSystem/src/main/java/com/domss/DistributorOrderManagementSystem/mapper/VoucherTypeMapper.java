package com.example.imperio.mapper;

import com.example.imperio.dto.VoucherTypeCreateDto;
import com.example.imperio.entity.VoucherTypeCreate;

public class VoucherTypeMapper {

    public static VoucherTypeCreateDto mapToVoucherTypeMasterCreateDto(VoucherTypeCreate voucherTypeCreate){
        return new VoucherTypeCreateDto(
                voucherTypeCreate.getVoucherTypeName(),
                voucherTypeCreate.getVoucherType(),
                voucherTypeCreate.getMethodOfVoucherNumbering(),
                voucherTypeCreate.getAlterAdditionalNumberingDetails(),
                voucherTypeCreate.getStartingNumber(),
                voucherTypeCreate.getWidthOfNumericalPart(),
                voucherTypeCreate.getPrefillWithZero(),
                voucherTypeCreate.getRestartNumberingApplicationForm(),
                voucherTypeCreate.getRestartNumberingStartingNumber(),
                voucherTypeCreate.getRestartNumberingPeriodicity(),
                voucherTypeCreate.getPrefixDetailsApplicationForm(),
                voucherTypeCreate.getPrefixDetailsParticulars(),
                voucherTypeCreate.getSuffixDetailsApplicationForm(),
                voucherTypeCreate.getSuffixDetailsParticulars(),
                voucherTypeCreate.getPrintingVoucherAfterSaving(),
                voucherTypeCreate.getNameOfClass()
        );
    }

    public static VoucherTypeCreate mapToVoucherTypeMasterCreate(VoucherTypeCreateDto voucherTypeCreateDto){
        return new VoucherTypeCreate(
                voucherTypeCreateDto.getVoucherTypeName(),
                voucherTypeCreateDto.getVoucherType(),
                voucherTypeCreateDto.getMethodOfVoucherNumbering(),
                voucherTypeCreateDto.getAlterAdditionalNumberingDetails(),
                voucherTypeCreateDto.getStartingNumber(),
                voucherTypeCreateDto.getWidthOfNumericalPart(),
                voucherTypeCreateDto.getPrefillWithZero(),
                voucherTypeCreateDto.getRestartNumberingApplicationForm(),
                voucherTypeCreateDto.getRestartNumberingStartingNumber(),
                voucherTypeCreateDto.getRestartNumberingPeriodicity(),
                voucherTypeCreateDto.getPrefixDetailsApplicationForm(),
                voucherTypeCreateDto.getPrefixDetailsParticulars(),
                voucherTypeCreateDto.getSuffixDetailsApplicationForm(),
                voucherTypeCreateDto.getSuffixDetailsParticulars(),
                voucherTypeCreateDto.getPrintingVoucherAfterSaving(),
                voucherTypeCreateDto.getNameOfClass()
        );
    }
}
