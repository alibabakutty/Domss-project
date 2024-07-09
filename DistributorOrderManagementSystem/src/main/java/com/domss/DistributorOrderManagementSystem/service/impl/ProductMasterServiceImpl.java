package com.example.imperio.service.impl;

import com.example.imperio.dto.ProductMasterCreateDto;
import com.example.imperio.entity.ProductMasterCreate;
import com.example.imperio.exception.ResourceNotFoundException;
import com.example.imperio.mapper.ProductMasterCreateMapper;
import com.example.imperio.repository.ProductMasterDAO;
import com.example.imperio.service.ProductMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductMasterServiceImpl implements ProductMasterService {

    @Autowired
    private ProductMasterDAO productMasterDAO;

    @Override
    public ProductMasterCreateDto createProductMaster(ProductMasterCreateDto productMasterCreateDto){


        // Validate for product object
        validateProductMaster(productMasterCreateDto);

        // check for duplicate entry
        if(productMasterDAO.existsByProductCode(productMasterCreateDto.getProductCode())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + productMasterCreateDto.getProductCode());

        }

        ProductMasterCreate productMasterCreate = ProductMasterCreateMapper.mapToProductMasterCreate(productMasterCreateDto);

        ProductMasterCreate savedProductMasterCreate = productMasterDAO.save(productMasterCreate);

        return ProductMasterCreateMapper.mapToProductMasterCreateDto(savedProductMasterCreate);
    }

    private void validateProductMaster(ProductMasterCreateDto productMasterCreateDto){

        if(productMasterCreateDto.getProductCode() == null || productMasterCreateDto.getProductCode().isEmpty()){

            throw new IllegalArgumentException("Unique field cannot be empty");

        }
    }


    @Override
    public ProductMasterCreateDto getProductMaster(String productCode){

        ProductMasterCreate productMasterCreate = productMasterDAO.findById(productCode).orElseThrow(()->
                new ResourceNotFoundException("Product is not found with this name:" + productCode));

        return ProductMasterCreateMapper.mapToProductMasterCreateDto(productMasterCreate);
    }

    @Override
    public List<ProductMasterCreateDto> getAllProductMasterCodes(){

        List<ProductMasterCreate> productMasterCreate = productMasterDAO.findAll();

        return productMasterCreate.stream().map(ProductMasterCreateMapper::mapToProductMasterCreateDto).toList();

    }

    @Override
    public ProductMasterCreateDto updateProduct(String productCode, ProductMasterCreateDto updatedProduct){

        ProductMasterCreate productMasterCreate = productMasterDAO.findById(productCode).orElseThrow(() ->


                new ResourceNotFoundException("Product is not found with the given name:" + productCode));


        productMasterCreate.setProductCode(updatedProduct.getProductCode());
        productMasterCreate.setProductDescription(updatedProduct.getProductDescription());
        productMasterCreate.setProductCategory(updatedProduct.getProductCategory());
        productMasterCreate.setProductUom(updatedProduct.getProductUom());
        productMasterCreate.setProductGroup(updatedProduct.getProductGroup());
        productMasterCreate.setStandardCost(updatedProduct.getStandardCost());
        productMasterCreate.setSellingPrice(updatedProduct.getSellingPrice());
        productMasterCreate.setDiscount(updatedProduct.getDiscount());

        ProductMasterCreate productMasterCreateObj = productMasterDAO.save(productMasterCreate);

        return ProductMasterCreateMapper.mapToProductMasterCreateDto(productMasterCreateObj);


    }

    @Override
    public void deleteProduct(String productCode){

        ProductMasterCreate productMasterCreate = productMasterDAO.findById(productCode).orElseThrow(() ->

                new ResourceNotFoundException("Product is not exists with this given name: " + productCode));

        productMasterDAO.deleteById(productCode);

    }
}
