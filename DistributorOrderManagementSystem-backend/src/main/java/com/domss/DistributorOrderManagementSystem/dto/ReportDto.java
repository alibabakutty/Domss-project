package com.domss.DistributorOrderManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportDto {

    private String voucherType;
    private String voucherNo;
    private LocalDate voucherDate;
    private String distributorName;
    private String distributorCode;

    private String category;
    private String code;
    private String description;
    private Double orderQty;
    private String uom;
    private Double approvedQuantity;
    private Double rate;
    private Double discount;
    private Double amount;

    private String createdBy;
    private LocalDateTime createdDateTime;
    private String approvedBy;
    private LocalDateTime approvedDateTime;
    private String narration;

}
