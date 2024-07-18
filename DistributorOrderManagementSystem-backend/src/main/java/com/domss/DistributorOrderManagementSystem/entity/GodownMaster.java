package com.domss.DistributorOrderManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "godown_master")
public class GodownMaster {


    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_seq")
    @Column(name = "id")
    private Long id;


    @Column(name = "godown_code", nullable = false, unique = true)
    private String godownCode;

    @Column(name = "godown_name")
    private String godownName;


}
