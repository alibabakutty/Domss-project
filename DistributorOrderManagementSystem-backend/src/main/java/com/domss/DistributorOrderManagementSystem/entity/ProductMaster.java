package com.domss.DistributorOrderManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product_master")
public class ProductMaster {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "stock_item_name")
    private String description;

    @Column(name = "stock_category")
    private String stockCategory;

    @Column(name = "uom")
    private String uom;

    @Column(name = "stock_group")
    private String stockGroup;

    @Column(name = "standard_cost")
    private Double standardCost;

    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "discount")
    private Double discount;


}
