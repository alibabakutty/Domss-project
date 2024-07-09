package com.example.imperio.mapper;

import com.example.imperio.dto.VoucherTypeMasterCreateDto;
import com.example.imperio.entity.VoucherTypeMasterCreate;

public class VoucherTypeMasterCreateMapper {

    public static VoucherTypeMasterCreateDto mapToVoucherTypeMasterCreateDto(VoucherTypeMasterCreate voucherTypeMasterCreate){

        return new VoucherTypeMasterCreateDto(
                voucherTypeMasterCreate.getVoucherTypeName(),
                voucherTypeMasterCreate.getVoucherType(),
                voucherTypeMasterCreate.getMethodOfVoucherNumbering(),
                voucherTypeMasterCreate.getAlterAdditionalNumberingDetails(),
                voucherTypeMasterCreate.getStartingNumber(),
                voucherTypeMasterCreate.getWidthOfNumericalPart(),
                voucherTypeMasterCreate.getPrefillWithZero(),
                voucherTypeMasterCreate.getRestartNumberingApplicationForm(),
                voucherTypeMasterCreate.getRestartNumberingStartingNumber(),
                voucherTypeMasterCreate.getRestartNumberingPeriodicity(),
                voucherTypeMasterCreate.getPrefixDetailsApplicationForm(),
                voucherTypeMasterCreate.getPrefixDetailsParticulars(),
                voucherTypeMasterCreate.getSuffixDetailsApplicationForm(),
                voucherTypeMasterCreate.getSuffixDetailsParticulars(),
                voucherTypeMasterCreate.getPrintingVoucherAfterSaving(),
                voucherTypeMasterCreate.getNameOfClass()
        );
    }


    public static VoucherTypeMasterCreate mapToVoucherTypeMasterCreate(VoucherTypeMasterCreateDto voucherTypeMasterCreateDto){
        return new VoucherTypeMasterCreate(
                voucherTypeMasterCreateDto.getVoucherTypeName(),
                voucherTypeMasterCreateDto.getVoucherType(),
                voucherTypeMasterCreateDto.getMethodOfVoucherNumbering(),
                voucherTypeMasterCreateDto.getAlterAdditionalNumberingDetails(),
                voucherTypeMasterCreateDto.getStartingNumber(),
                voucherTypeMasterCreateDto.getWidthOfNumericalPart(),
                voucherTypeMasterCreateDto.getPrefillWithZero(),
                voucherTypeMasterCreateDto.getRestartNumberingApplicationForm(),
                voucherTypeMasterCreateDto.getRestartNumberingStartingNumber(),
                voucherTypeMasterCreateDto.getRestartNumberingPeriodicity(),
                voucherTypeMasterCreateDto.getPrefixDetailsApplicationForm(),
                voucherTypeMasterCreateDto.getPrefixDetailsParticulars(),
                voucherTypeMasterCreateDto.getSuffixDetailsApplicationForm(),
                voucherTypeMasterCreateDto.getSuffixDetailsParticulars(),
                voucherTypeMasterCreateDto.getPrintingVoucherAfterSaving(),
                voucherTypeMasterCreateDto.getNameOfClass()
        );
    }
}
