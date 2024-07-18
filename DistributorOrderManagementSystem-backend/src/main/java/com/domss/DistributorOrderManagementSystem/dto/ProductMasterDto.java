package com.domss.DistributorOrderManagementSystem.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMasterDto {

    private Long id;

    private String productCode;

    private String description;

    private String stockCategory;

    private String uom;

    private String stockGroup;

    private Double standardCost;

    private Double sellingPrice;

    private Double discount;
}
