package com.domss.DistributorOrderManagementSystem.service;



import com.domss.DistributorOrderManagementSystem.dto.ProductMasterDto;

import java.util.List;

public interface ProductMasterService {


    ProductMasterDto createProductMaster(ProductMasterDto productMasterDto);

    ProductMasterDto getProductMaster(String productCode);

    List<ProductMasterDto> getAllProductMasterCodes();

    ProductMasterDto updateProduct(String productCode, ProductMasterDto updatedProduct);

    void deleteProduct(String productCode);

}
