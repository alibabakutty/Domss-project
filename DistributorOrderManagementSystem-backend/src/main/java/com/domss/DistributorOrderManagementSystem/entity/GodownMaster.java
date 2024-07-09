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
@Table(name = "godown_master")
public class GodownMaster {

    @Id
    @Column(name = "godown_code")
    private String godownCode;

    @Column(name = "godown_name")
    private String godownName;


}
