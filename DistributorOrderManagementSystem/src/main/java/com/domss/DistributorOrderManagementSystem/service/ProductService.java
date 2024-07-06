package com.domss.DistributorOrderManagementSystem.service;

import com.domss.DistributorOrderManagementSystem.entity.Product;
import com.domss.DistributorOrderManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> getAllProduct() {
        try {
            return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Product> getProductCode(String productCode) {
        try {
            return new ResponseEntity<>(productRepository.findByProductCode(productCode), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Product>> getStockGroup(String category) {
        try {
            return new ResponseEntity<>(productRepository.findByStockGroup(category), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>("Delted Successfully", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }


}
