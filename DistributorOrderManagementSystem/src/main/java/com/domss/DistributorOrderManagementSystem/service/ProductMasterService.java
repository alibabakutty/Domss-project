package com.example.imperio.service;

import com.example.imperio.dto.ProductMasterCreateDto;

import java.util.List;

public interface ProductMasterService {


    ProductMasterCreateDto createProductMaster(ProductMasterCreateDto productMasterCreateDto);

    ProductMasterCreateDto getProductMaster(String productCode);

    List<ProductMasterCreateDto> getAllProductMasterCodes();

    ProductMasterCreateDto updateProduct(String productCode, ProductMasterCreateDto updatedProduct);

    void deleteProduct(String productCode);

}
