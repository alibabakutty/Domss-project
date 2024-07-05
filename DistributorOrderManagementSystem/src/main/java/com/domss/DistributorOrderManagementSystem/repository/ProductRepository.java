package com.domss.DistributorOrderManagementSystem.repository;

import com.domss.DistributorOrderManagementSystem.entity.Product;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductCode(String productCode);

    List<Product> findByStockGroup(String category);
}
