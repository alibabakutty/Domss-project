package com.domss.DistributorOrderManagementSystem.mapper;


import com.domss.DistributorOrderManagementSystem.dto.VoucherTypeDto;
import com.domss.DistributorOrderManagementSystem.entity.VoucherType;

public class VoucherTypeMapper {

    public static VoucherTypeDto mapToVoucherTypeDto(VoucherType voucherType){
        return new VoucherTypeDto(
                voucherType.getId(),
                voucherType.getVoucherTypeName(),
                voucherType.getVoucherType(),
                voucherType.getMethodOfVoucherNumbering(),
                voucherType.getAlterAdditionalNumberingDetails(),
                voucherType.getStartingNumber(),
                voucherType.getWidthOfNumericalPart(),
                voucherType.getPrefillWithZero(),
                voucherType.getRestartNumberingApplicationForm(),
                voucherType.getRestartNumberingStartingNumber(),
                voucherType.getRestartNumberingPeriodicity(),
                voucherType.getPrefixDetailsApplicationForm(),
                voucherType.getPrefixDetailsParticulars(),
                voucherType.getSuffixDetailsApplicationForm(),
                voucherType.getSuffixDetailsParticulars(),
                voucherType.getPrintingVoucherAfterSaving(),
                voucherType.getNameOfClass()
        );
    }

    public static VoucherType mapToVoucherType(VoucherTypeDto voucherTypeDto){
        return new VoucherType(
                voucherTypeDto.getId(),
                voucherTypeDto.getVoucherTypeName(),
                voucherTypeDto.getVoucherType(),
                voucherTypeDto.getMethodOfVoucherNumbering(),
                voucherTypeDto.getAlterAdditionalNumberingDetails(),
                voucherTypeDto.getStartingNumber(),
                voucherTypeDto.getWidthOfNumericalPart(),
                voucherTypeDto.getPrefillWithZero(),
                voucherTypeDto.getRestartNumberingApplicationForm(),
                voucherTypeDto.getRestartNumberingStartingNumber(),
                voucherTypeDto.getRestartNumberingPeriodicity(),
                voucherTypeDto.getPrefixDetailsApplicationForm(),
                voucherTypeDto.getPrefixDetailsParticulars(),
                voucherTypeDto.getSuffixDetailsApplicationForm(),
                voucherTypeDto.getSuffixDetailsParticulars(),
                voucherTypeDto.getPrintingVoucherAfterSaving(),
                voucherTypeDto.getNameOfClass()
        );
    }
}
