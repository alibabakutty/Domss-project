package com.domss.DistributorOrderManagementSystem.service.impl;

import com.domss.DistributorOrderManagementSystem.dto.ProductMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.ProductMaster;
import com.domss.DistributorOrderManagementSystem.exception.ResourceNotFoundException;
import com.domss.DistributorOrderManagementSystem.mapper.ProductMasterMapper;
import com.domss.DistributorOrderManagementSystem.repository.ProductMasterRepository;
import com.domss.DistributorOrderManagementSystem.service.ProductMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductMasterServiceImpl implements ProductMasterService {

    @Autowired
    private ProductMasterRepository productMasterDAO;

    @Override
    public ProductMasterDto createProductMaster(ProductMasterDto productMasterDto){


        // Validate for product object
        validateProductMaster(productMasterDto);

        // check for duplicate entry
        if(productMasterDAO.existsByProductCode(productMasterDto.getProductCode())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + productMasterDto.getProductCode());

        }

        ProductMaster productMaster = ProductMasterMapper.mapToProductMaster(productMasterDto);

        ProductMaster savedProductMaster = productMasterDAO.save(productMaster);

        return ProductMasterMapper.mapToProductMasterDto(savedProductMaster);
    }

    private void validateProductMaster(ProductMasterDto productMasterDto){

        if(productMasterDto.getProductCode() == null || productMasterDto.getProductCode().isEmpty()){

            throw new IllegalArgumentException("Unique field cannot be empty");

        }
    }


    @Override
    public ProductMasterDto getProductMaster(String productCode){

        ProductMaster productMaster = productMasterDAO.findByProductCode(productCode).orElseThrow(()->
                new ResourceNotFoundException("Product is not found with this name:" + productCode));

        return ProductMasterMapper.mapToProductMasterDto(productMaster);
    }

    @Override
    public List<ProductMasterDto> getAllProductMasterCodes(){

        List<ProductMaster> productMaster = productMasterDAO.findAll();

        return productMaster.stream().map(ProductMasterMapper::mapToProductMasterDto).toList();

    }

    @Override
    public ProductMasterDto updateProduct(String productCode, ProductMasterDto updatedProduct){

        ProductMaster productMaster = productMasterDAO.findByProductCode(productCode).orElseThrow(() ->


                new ResourceNotFoundException("Product is not found with the given name:" + productCode));


        productMaster.setProductCode(updatedProduct.getProductCode());
        productMaster.setDescription(updatedProduct.getDescription());
        productMaster.setStockCategory(updatedProduct.getStockCategory());
        productMaster.setUom(updatedProduct.getUom());
        productMaster.setStockGroup(updatedProduct.getStockGroup());
        productMaster.setStandardCost(updatedProduct.getStandardCost());
        productMaster.setSellingPrice(updatedProduct.getSellingPrice());
        productMaster.setDiscount(updatedProduct.getDiscount());

        ProductMaster productMasterObj = productMasterDAO.save(productMaster);

        return ProductMasterMapper.mapToProductMasterDto(productMasterObj);


    }

    @Override
    public void deleteProduct(String productCode){

        ProductMaster productMaster = productMasterDAO.findByProductCode(productCode).orElseThrow(() ->

                new ResourceNotFoundException("Product is not exists with this given name: " + productCode));

        productMasterDAO.deleteById(Long.valueOf(productCode));

    }
}