package com.domss.DistributorOrderManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id

    @Column(name = "id")
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "stock_item_name")
    private String stockItemName;

    @Column(name = "stock_group")
    private String stockGroup;

    @Column(name = "stock_category")
    private String stockCategory;

    @Column(name = "standard_cost")
    private Long standardCost;

    @Column(name = "selling_price")
    private Double rate;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "uom")
    private String uom;


}
