package com.domss.DistributorOrderManagementSystem.controller;

import com.domss.DistributorOrderManagementSystem.dto.ProductMasterDto;
import com.domss.DistributorOrderManagementSystem.service.ProductMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/products")
public class ProductMasterController {

    @Autowired
    private ProductMasterService productMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addProduct")
    public ResponseEntity<ProductMasterDto> createProductMaster(@RequestBody ProductMasterDto productMasterDto){

        ProductMasterDto saveProductMaster = productMasterService.createProductMaster(productMasterDto);

        return new ResponseEntity<>(saveProductMaster, HttpStatus.CREATED);

    }


    //Build GET Master Ids REST API
    @GetMapping("/displayProduct/{productCode}")
    public ResponseEntity<ProductMasterDto> getDataByProductCode(@PathVariable String productCode){

        ProductMasterDto productMasterDto = productMasterService.getProductMaster(productCode);

        return ResponseEntity.ok(productMasterDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductMasterDto>> getAllProducts(){

        List<ProductMasterDto> allProducts = productMasterService.getAllProductMasterCodes();

        return ResponseEntity.ok(allProducts);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterProductMaster/{productCode}")
    public ResponseEntity<ProductMasterDto> updateProduct(@PathVariable String productCode, @RequestBody ProductMasterDto updatedProduct){

        ProductMasterDto productMasterDto = productMasterService.updateProduct(productCode,updatedProduct);

        return ResponseEntity.ok(productMasterDto);

    }


    //Build DELETE Ledger REST API
    @DeleteMapping("deleteProduct/{productCode}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productCode){

        productMasterService.deleteProduct(productCode);

        return ResponseEntity.ok("Product deleted successfully!");

    }
}
