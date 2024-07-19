package com.domss.DistributorOrderManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "unit_master")
public class UnitMaster {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @Column(name = "id")
    private Long id;


    @Column(name = "product_uom", nullable = false, unique = true)
    private String productUom;

    @Column(name = "uom")
    private String uom;
}
