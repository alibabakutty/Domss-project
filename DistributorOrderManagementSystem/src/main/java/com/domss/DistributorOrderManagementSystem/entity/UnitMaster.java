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
@Table(name = "unit_master")
public class UnitMaster {

    @Id
    @Column(name = "product_uom")
    private String productUom;
}
