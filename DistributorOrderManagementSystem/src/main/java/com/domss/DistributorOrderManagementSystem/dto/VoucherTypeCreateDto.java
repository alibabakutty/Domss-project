package com.example.imperio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoucherTypeCreateDto {

    private String voucherTypeName;

    private String voucherType;

    private String methodOfVoucherNumbering;

    private String alterAdditionalNumberingDetails;

    private String startingNumber;

    private String widthOfNumericalPart;

    private String prefillWithZero;

    private String restartNumberingApplicationForm;

    private String restartNumberingStartingNumber;

    private String restartNumberingPeriodicity;

    private String prefixDetailsApplicationForm;

    private String prefixDetailsParticulars;

    private String suffixDetailsApplicationForm;

    private String suffixDetailsParticulars;

    private String printingVoucherAfterSaving;

    private String nameOfClass;
}
