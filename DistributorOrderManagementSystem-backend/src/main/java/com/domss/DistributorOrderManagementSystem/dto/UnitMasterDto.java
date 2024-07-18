package com.domss.DistributorOrderManagementSystem.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitMasterDto {

    private Long id;

    private String productUom;

    private String uom;
}
