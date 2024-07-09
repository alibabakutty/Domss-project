package com.example.imperio.mapper;

import com.example.imperio.dto.ProductMasterCreateDto;
import com.example.imperio.entity.ProductMasterCreate;

public class ProductMasterCreateMapper {


    public static ProductMasterCreateDto mapToProductMasterCreateDto(ProductMasterCreate productMasterCreate){

        return new ProductMasterCreateDto(

                productMasterCreate.getProductCode(),
                productMasterCreate.getProductDescription(),
                productMasterCreate.getProductCategory(),
                productMasterCreate.getProductUom(),
                productMasterCreate.getProductGroup(),
                productMasterCreate.getStandardCost(),
                productMasterCreate.getSellingPrice(),
                productMasterCreate.getDiscount()
        );
    }


    public static ProductMasterCreate mapToProductMasterCreate(ProductMasterCreateDto productMasterCreateDto){


        return new ProductMasterCreate(

                productMasterCreateDto.getProductCode(),
                productMasterCreateDto.getProductDescription(),
                productMasterCreateDto.getProductCategory(),
                productMasterCreateDto.getProductUom(),
                productMasterCreateDto.getProductGroup(),
                productMasterCreateDto.getStandardCost(),
                productMasterCreateDto.getSellingPrice(),
                productMasterCreateDto.getDiscount()
        );
    }
}
