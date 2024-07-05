package com.domss.DistributorOrderManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    @Id
    @SequenceGenerator(
            name = "order_item_seq",
            sequenceName = "order_item_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_item_seq"
    )
    @Column(name = "order_item")
    private Long Id;

    @Column(name = "stock_category")
    private String category;

    @Column(name = "product_code")
    private String code;

    @Column(name = "stock_item_code")
    private String description;

    @Column(name = "order_quantity")
    private Double orderQty;

    @Column(name = "units_of_measurement")
    private String uom;

    @Column(name = "approved_quantity")
    private Double approvedQuantity;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "amount")
    private Double amount;
}
