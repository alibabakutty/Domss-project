package com.example.imperio.controller;

import com.example.imperio.dto.ProductMasterCreateDto;
import com.example.imperio.service.ProductMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4000")
@RestController
@RequestMapping("/productMasterApi")
public class ProductMasterController {

    @Autowired
    private ProductMasterService productMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addProduct")
    public ResponseEntity<ProductMasterCreateDto> createProductMaster(@RequestBody ProductMasterCreateDto productMasterCreateDto){

        ProductMasterCreateDto saveProductMaster = productMasterService.createProductMaster(productMasterCreateDto);

        return new ResponseEntity<>(saveProductMaster, HttpStatus.CREATED);

    }


    //Build GET Master Ids REST API
    @GetMapping("/displayProduct/{productCode}")
    public ResponseEntity<ProductMasterCreateDto> getDataByProductCode(@PathVariable String productCode){

        ProductMasterCreateDto productMasterCreateDto = productMasterService.getProductMaster(productCode);

        return ResponseEntity.ok(productMasterCreateDto);

    }

    //Build GET All Master Ids REST API
    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductMasterCreateDto>> getAllProducts(){

        List<ProductMasterCreateDto> allProducts = productMasterService.getAllProductMasterCodes();

        return ResponseEntity.ok(allProducts);

    }

    //Build UPDATE Master REST API
    @PutMapping("/alterProductMaster/{productCode}")
    public ResponseEntity<ProductMasterCreateDto> updateProduct(@PathVariable String productCode, @RequestBody ProductMasterCreateDto updatedProduct){

        ProductMasterCreateDto productMasterCreateDto = productMasterService.updateProduct(productCode,updatedProduct);

        return ResponseEntity.ok(productMasterCreateDto);

    }


    //Build DELETE Ledger REST API
    @DeleteMapping("deleteProduct/{productCode}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productCode){

        productMasterService.deleteProduct(productCode);

        return ResponseEntity.ok("Product deleted successfully!");

    }
}
