package com.domss.DistributorOrderManagementSystem.mapper;


import com.domss.DistributorOrderManagementSystem.dto.ProductMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.ProductMaster;

public class ProductMasterMapper {


    public static ProductMasterDto mapToProductMasterDto(ProductMaster productMaster){

        return new ProductMasterDto(

                productMaster.getProductCode(),
                productMaster.getProductDescription(),
                productMaster.getProductCategory(),
                productMaster.getProductUom(),
                productMaster.getProductGroup(),
                productMaster.getStandardCost(),
                productMaster.getSellingPrice(),
                productMaster.getDiscount()
        );
    }


    public static ProductMaster mapToProductMaster(ProductMasterDto productMasterDto){


        return new ProductMaster(

                productMasterDto.getProductCode(),
                productMasterDto.getProductDescription(),
                productMasterDto.getProductCategory(),
                productMasterDto.getProductUom(),
                productMasterDto.getProductGroup(),
                productMasterDto.getStandardCost(),
                productMasterDto.getSellingPrice(),
                productMasterDto.getDiscount()
        );
    }
}
