package com.example.imperio.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMasterCreateDto {

    private String productCode;


    private String productDescription;


    private String productCategory;


    private String productUom;

    private String productGroup;

    private Long standardCost;

    private Long sellingPrice;

    private Long discount;
}
