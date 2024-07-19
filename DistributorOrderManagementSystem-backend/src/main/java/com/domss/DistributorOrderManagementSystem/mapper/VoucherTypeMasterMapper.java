package com.domss.DistributorOrderManagementSystem.mapper;


import com.domss.DistributorOrderManagementSystem.dto.VoucherTypeMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.VoucherTypeMaster;

public class VoucherTypeMasterMapper {

    public static VoucherTypeMasterDto mapToVoucherTypeMasterDto(VoucherTypeMaster voucherTypeMaster){

        return new VoucherTypeMasterDto(
                voucherTypeMaster.getId(),
                voucherTypeMaster.getVoucherTypeName(),
                voucherTypeMaster.getVoucherType(),
                voucherTypeMaster.getMethodOfVoucherNumbering(),
                voucherTypeMaster.getAlterAdditionalNumberingDetails(),
                voucherTypeMaster.getStartingNumber(),
                voucherTypeMaster.getWidthOfNumericalPart(),
                voucherTypeMaster.getPrefillWithZero(),
                voucherTypeMaster.getRestartNumberingApplicationForm(),
                voucherTypeMaster.getRestartNumberingStartingNumber(),
                voucherTypeMaster.getRestartNumberingPeriodicity(),
                voucherTypeMaster.getPrefixDetailsApplicationForm(),
                voucherTypeMaster.getPrefixDetailsParticulars(),
                voucherTypeMaster.getSuffixDetailsApplicationForm(),
                voucherTypeMaster.getSuffixDetailsParticulars(),
                voucherTypeMaster.getPrintingVoucherAfterSaving(),
                voucherTypeMaster.getNameOfClass()
        );
    }


    public static VoucherTypeMaster mapToVoucherTypeMaster(VoucherTypeMasterDto voucherTypeMasterDto){
        return new VoucherTypeMaster(
                voucherTypeMasterDto.getId(),
                voucherTypeMasterDto.getVoucherTypeName(),
                voucherTypeMasterDto.getVoucherType(),
                voucherTypeMasterDto.getMethodOfVoucherNumbering(),
                voucherTypeMasterDto.getAlterAdditionalNumberingDetails(),
                voucherTypeMasterDto.getStartingNumber(),
                voucherTypeMasterDto.getWidthOfNumericalPart(),
                voucherTypeMasterDto.getPrefillWithZero(),
                voucherTypeMasterDto.getRestartNumberingApplicationForm(),
                voucherTypeMasterDto.getRestartNumberingStartingNumber(),
                voucherTypeMasterDto.getRestartNumberingPeriodicity(),
                voucherTypeMasterDto.getPrefixDetailsApplicationForm(),
                voucherTypeMasterDto.getPrefixDetailsParticulars(),
                voucherTypeMasterDto.getSuffixDetailsApplicationForm(),
                voucherTypeMasterDto.getSuffixDetailsParticulars(),
                voucherTypeMasterDto.getPrintingVoucherAfterSaving(),
                voucherTypeMasterDto.getNameOfClass()
        );
    }
}
