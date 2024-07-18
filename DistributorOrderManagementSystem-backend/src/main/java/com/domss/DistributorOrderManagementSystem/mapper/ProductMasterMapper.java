package com.domss.DistributorOrderManagementSystem.mapper;


import com.domss.DistributorOrderManagementSystem.dto.ProductMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.ProductMaster;

public class ProductMasterMapper {


    public static ProductMasterDto mapToProductMasterDto(ProductMaster productMaster){

        return new ProductMasterDto(
                productMaster.getId(),
                productMaster.getProductCode(),
                productMaster.getDescription(),
                productMaster.getStockCategory(),
                productMaster.getUom(),
                productMaster.getStockGroup(),
                productMaster.getStandardCost(),
                productMaster.getSellingPrice(),
                productMaster.getDiscount()
        );
    }


    public static ProductMaster mapToProductMaster(ProductMasterDto productMasterDto){


        return new ProductMaster(
                productMasterDto.getId(),
                productMasterDto.getProductCode(),
                productMasterDto.getDescription(),
                productMasterDto.getStockCategory(),
                productMasterDto.getUom(),
                productMasterDto.getStockGroup(),
                productMasterDto.getStandardCost(),
                productMasterDto.getSellingPrice(),
                productMasterDto.getDiscount()
        );
    }
}
