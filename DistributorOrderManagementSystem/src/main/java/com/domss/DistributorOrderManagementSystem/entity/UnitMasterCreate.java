package com.example.imperio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "unit_master")
public class UnitMasterCreate {

    @Id
    @Column(name = "product_uom")
    private String productUom;
}
