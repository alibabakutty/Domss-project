package com.domss.DistributorOrderManagementSystem.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMasterDto {

    private String productCode;


    private String productDescription;


    private String productCategory;


    private String productUom;

    private String productGroup;

    private Long standardCost;

    private Long sellingPrice;

    private Long discount;
}
