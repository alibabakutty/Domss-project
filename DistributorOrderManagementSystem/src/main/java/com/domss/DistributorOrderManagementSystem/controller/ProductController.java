package com.domss.DistributorOrderManagementSystem.controller;

import com.domss.DistributorOrderManagementSystem.entity.Product;
import com.domss.DistributorOrderManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("get")
    public ResponseEntity<List<Product>> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("get/productCode/{productCode}")
    public ResponseEntity<Product> getProductCode(@PathVariable String productCode){
        return productService.getProductCode(productCode);
    }

    @GetMapping("get/category/{category}")
    public ResponseEntity<List<Product>> getStockGroup(@PathVariable("category") String stockGroup){
        return productService.getStockGroup(stockGroup);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
